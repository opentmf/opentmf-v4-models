package org.opentmf.tmf678.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-678: Customer Bill Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum StateValues {

  IN_PROGRESS("inProgress"),
  REJECTED("rejected"),
  DONE("done"),
  TERMINATED_WITH_ERROR("terminatedWithError");

  private final String value;

  StateValues(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, StateValues> REVERSE_MAP = new HashMap<>();

  static {
    for (StateValues stateValues : values()) {
      REVERSE_MAP.put(stateValues.getValue(), stateValues);
    }
  }

  @JsonCreator
  public static StateValues resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
