package org.opentmf.tmf701.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for the lifecycle state of the taskFlow.
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
public enum TaskFlowStateType {

  NEW("new"),
  ACTIVE("active"),
  HOLD("hold"),
  CANCELLED("cancelled"),
  COMPLETED("completed");

  private final String value;

  TaskFlowStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, TaskFlowStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (TaskFlowStateType taskFlowStateType : values()) {
      REVERSE_MAP.put(taskFlowStateType.getValue(), taskFlowStateType);
    }
  }

  @JsonCreator
  public static TaskFlowStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
