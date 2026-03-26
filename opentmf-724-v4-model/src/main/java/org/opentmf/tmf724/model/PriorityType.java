package org.opentmf.tmf724.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the Priority of an Incident.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-724: Incident Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum PriorityType {

  CRITICAL("critical"),
  HIGH("high"),
  MEDIUM("medium"),
  LOW("low");

  private final String value;

  PriorityType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, PriorityType> REVERSE_MAP = new HashMap<>();

  static {
    for (PriorityType priorityType : values()) {
      REVERSE_MAP.put(priorityType.getValue(), priorityType);
    }
  }

  @JsonCreator
  public static PriorityType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
