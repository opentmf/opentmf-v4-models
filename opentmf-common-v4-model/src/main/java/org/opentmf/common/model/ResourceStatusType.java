package org.opentmf.common.model;

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
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-716: ResourceReservation</li>
 *   <li>TMF-730: Software And Compute Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
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
