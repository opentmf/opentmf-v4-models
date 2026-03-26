package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for the lifecycle state of the service.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-640: Service Activation Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-645: Service Qualification Management API</li>
 *   <li>TMF-915: AI Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ServiceStateType {

  FEASIBILITY_CHECKED("feasibilityChecked"),
  DESIGNED("designed"),
  RESERVED("reserved"),
  INACTIVE("inactive"),
  ACTIVE("active"),
  TERMINATED("terminated");

  private final String value;

  ServiceStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ServiceStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ServiceStateType serviceStateType : values()) {
      REVERSE_MAP.put(serviceStateType.getValue(), serviceStateType);
    }
  }

  @JsonCreator
  public static ServiceStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
