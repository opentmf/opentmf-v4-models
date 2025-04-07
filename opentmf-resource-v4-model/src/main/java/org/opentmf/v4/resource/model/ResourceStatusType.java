package org.opentmf.v4.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * ResourceStatusType enumerations.
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
public enum ResourceStatusType {

  STANDBY("standby"),
  ALARM("alarm"),
  AVAILABLE("available"),
  RESERVED("reserved"),
  UNKNOWN("unknown"),
  SUSPENDED("suspended");

  private final String value;

  ResourceStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ResourceStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (ResourceStatusType resourceStatusType : values()) {
      REVERSE_MAP.put(resourceStatusType.getValue(), resourceStatusType);
    }
  }

  @JsonCreator
  public static ResourceStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
