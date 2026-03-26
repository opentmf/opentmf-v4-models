package org.opentmf.tmf701.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for the lifecycle state of the processFlow.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-701: Process Flow Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ProcessFlowStateType {

  ACTIVE("active"),
  CANCELLED("cancelled"),
  HOLD("hold"),
  COMPLETED("completed");

  private final String value;

  ProcessFlowStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ProcessFlowStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ProcessFlowStateType processFlowStateType : values()) {
      REVERSE_MAP.put(processFlowStateType.getValue(), processFlowStateType);
    }
  }

  @JsonCreator
  public static ProcessFlowStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
