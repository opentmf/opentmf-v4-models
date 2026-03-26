package org.opentmf.tmf724.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the urgency of an Incident.
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
public enum UrgencyType {

  CRITICAL("critical"),
  HIGH("high"),
  MEDIUM("medium"),
  LOW("low");

  private final String value;

  UrgencyType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, UrgencyType> REVERSE_MAP = new HashMap<>();

  static {
    for (UrgencyType urgencyType : values()) {
      REVERSE_MAP.put(urgencyType.getValue(), urgencyType);
    }
  }

  @JsonCreator
  public static UrgencyType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
