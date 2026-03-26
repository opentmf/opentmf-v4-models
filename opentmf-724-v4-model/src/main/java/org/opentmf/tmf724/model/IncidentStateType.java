package org.opentmf.tmf724.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the state of an Incident.
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
public enum IncidentStateType {

  RAISED("raised"),
  UPDATED("updated"),
  CLEARED("cleared");

  private final String value;

  IncidentStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, IncidentStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (IncidentStateType incidentStateType : values()) {
      REVERSE_MAP.put(incidentStateType.getValue(), incidentStateType);
    }
  }

  @JsonCreator
  public static IncidentStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
