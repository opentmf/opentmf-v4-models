package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-713: Work Management</li>
 *   <li>TMF-714: Work Qualification Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum WorkforceEmployeeAssignmentStateType {

  ACKNOWLEDGED("acknowledged"),
  REJECTED("rejected"),
  PENDING("pending"),
  HELD("held"),
  IN_PROGRESS("inProgress"),
  CANCELLED("cancelled"),
  COMPLETED("completed"),
  FAILED("failed"),
  PARTIAL("partial");

  private final String value;

  WorkforceEmployeeAssignmentStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, WorkforceEmployeeAssignmentStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (WorkforceEmployeeAssignmentStateType workforceEmployeeAssignmentStateType : values()) {
      REVERSE_MAP.put(workforceEmployeeAssignmentStateType.getValue(), workforceEmployeeAssignmentStateType);
    }
  }

  @JsonCreator
  public static WorkforceEmployeeAssignmentStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
