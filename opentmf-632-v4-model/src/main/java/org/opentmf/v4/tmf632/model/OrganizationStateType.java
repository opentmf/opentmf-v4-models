package org.opentmf.v4.tmf632.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for the lifecycle state of the organization.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
public enum OrganizationStateType {

  INITIALIZED("initialized"),
  VALIDATED("validated"),
  CLOSED("closed");

  private final String value;

  OrganizationStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, OrganizationStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (OrganizationStateType organizationStateType : values()) {
      REVERSE_MAP.put(organizationStateType.getValue(), organizationStateType);
    }
  }

  @JsonCreator
  public static OrganizationStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
