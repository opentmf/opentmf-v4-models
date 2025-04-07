package org.opentmf.v4.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * ResourceOperationalStateType enumerations.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
public enum ResourceOperationalStateType {

  ENABLE("enable"),
  DISABLE("disable");

  private final String value;

  ResourceOperationalStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ResourceOperationalStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ResourceOperationalStateType resourceOperationalStateType : values()) {
      REVERSE_MAP.put(resourceOperationalStateType.getValue(), resourceOperationalStateType);
    }
  }

  @JsonCreator
  public static ResourceOperationalStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
