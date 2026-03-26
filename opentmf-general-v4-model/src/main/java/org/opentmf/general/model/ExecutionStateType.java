package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the state of the execution.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-707: Test Result Management API</li>
 *   <li>TMF-708: Test Execution Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ExecutionStateType {

  ACKNOWLEDGED("acknowledged"),
  REJECTED("rejected"),
  PENDING("pending"),
  IN_PROGRESS("inProgress"),
  CANCELLED("cancelled"),
  COMPLETED("completed"),
  FAILED("failed");

  private final String value;

  ExecutionStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ExecutionStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ExecutionStateType executionStateType : values()) {
      REVERSE_MAP.put(executionStateType.getValue(), executionStateType);
    }
  }

  @JsonCreator
  public static ExecutionStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
