package org.opentmf.tmf644.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the status of party privacy profile (for example:
 * created, terminated).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-644: Privacy Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum PartyPrivacyProfileStatusExampleType {

  CREATED("created"),
  TERMINATED("terminated");

  private final String value;

  PartyPrivacyProfileStatusExampleType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, PartyPrivacyProfileStatusExampleType> REVERSE_MAP = new HashMap<>();

  static {
    for (PartyPrivacyProfileStatusExampleType partyPrivacyProfileStatusExampleType : values()) {
      REVERSE_MAP.put(partyPrivacyProfileStatusExampleType.getValue(), partyPrivacyProfileStatusExampleType);
    }
  }

  @JsonCreator
  public static PartyPrivacyProfileStatusExampleType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
