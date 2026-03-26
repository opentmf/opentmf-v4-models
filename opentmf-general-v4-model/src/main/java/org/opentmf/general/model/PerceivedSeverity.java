package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * This datatype lists the possible severities that can be allocated to a Alarm.
 * The values are consistent with ITU-T Recommendation X.733. This specification
 * does not recommend the use of indeterminate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-649: Performance Thresholding Management API</li>
 *   <li>TMF-915: AI Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum PerceivedSeverity {

  CRITICAL("CRITICAL"),
  MAJOR("MAJOR"),
  MINOR("MINOR"),
  WARNING("WARNING"),
  INDETERMINATE("INDETERMINATE"),
  CLEARED("CLEARED");

  private final String value;

  PerceivedSeverity(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, PerceivedSeverity> REVERSE_MAP = new HashMap<>();

  static {
    for (PerceivedSeverity perceivedSeverity : values()) {
      REVERSE_MAP.put(perceivedSeverity.getValue(), perceivedSeverity);
    }
  }

  @JsonCreator
  public static PerceivedSeverity resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
