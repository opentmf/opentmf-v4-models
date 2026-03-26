package org.opentmf.tmf644.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the status of party privacy profile Specification (for
 * example: inDesign, active, rejected, retired).
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
public enum PartyPrivacyProfileSpecificationStatusExampleType {

  IN_DESIGN("inDesign"),
  ACTIVE("active"),
  REJECTED("rejected"),
  RETIRED("retired");

  private final String value;

  PartyPrivacyProfileSpecificationStatusExampleType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, PartyPrivacyProfileSpecificationStatusExampleType> REVERSE_MAP = new HashMap<>();

  static {
    for (PartyPrivacyProfileSpecificationStatusExampleType partyPrivacyProfileSpecificationStatusExampleType : values()) {
      REVERSE_MAP.put(partyPrivacyProfileSpecificationStatusExampleType.getValue(), partyPrivacyProfileSpecificationStatusExampleType);
    }
  }

  @JsonCreator
  public static PartyPrivacyProfileSpecificationStatusExampleType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
