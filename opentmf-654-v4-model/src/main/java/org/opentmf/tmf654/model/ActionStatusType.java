package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for the Action Status Type.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-654: Prepay Balance Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ActionStatusType {

  CREATED("created"),
  FAILED("failed"),
  CANCELLED("cancelled"),
  COMPLETED("completed");

  private final String value;

  ActionStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ActionStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (ActionStatusType actionStatusType : values()) {
      REVERSE_MAP.put(actionStatusType.getValue(), actionStatusType);
    }
  }

  @JsonCreator
  public static ActionStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
