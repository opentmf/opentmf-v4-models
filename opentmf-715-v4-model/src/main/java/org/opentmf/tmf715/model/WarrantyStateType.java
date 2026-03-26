package org.opentmf.tmf715.model;

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
 *   <li>TMF-715: Warranty Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum WarrantyStateType {

  FEASIBILITY_CHECKED("feasibilityChecked"),
  DESIGNED("designed"),
  RESERVED("reserved"),
  INACTIVE("inactive"),
  ACTIVE("active"),
  TERMINATED("terminated");

  private final String value;

  WarrantyStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, WarrantyStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (WarrantyStateType warrantyStateType : values()) {
      REVERSE_MAP.put(warrantyStateType.getValue(), warrantyStateType);
    }
  }

  @JsonCreator
  public static WarrantyStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
