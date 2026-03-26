package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * ResourceAdministrativeStateType enumerations.
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
public enum ResourceAdministrativeStateType {

  LOCKED("locked"),
  UNLOCKED("unlocked"),
  SHUTDOWN("shutdown");

  private final String value;

  ResourceAdministrativeStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ResourceAdministrativeStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ResourceAdministrativeStateType resourceAdministrativeStateType : values()) {
      REVERSE_MAP.put(resourceAdministrativeStateType.getValue(), resourceAdministrativeStateType);
    }
  }

  @JsonCreator
  public static ResourceAdministrativeStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
