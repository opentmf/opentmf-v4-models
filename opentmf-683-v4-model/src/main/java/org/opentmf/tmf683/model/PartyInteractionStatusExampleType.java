package org.opentmf.tmf683.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the status of party interaction.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-683: Party Interaction Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum PartyInteractionStatusExampleType {

  OPEN("open"),
  IN_PROGRESS("inProgress"),
  COMPLETED("completed");

  private final String value;

  PartyInteractionStatusExampleType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, PartyInteractionStatusExampleType> REVERSE_MAP = new HashMap<>();

  static {
    for (PartyInteractionStatusExampleType partyInteractionStatusExampleType : values()) {
      REVERSE_MAP.put(partyInteractionStatusExampleType.getValue(), partyInteractionStatusExampleType);
    }
  }

  @JsonCreator
  public static PartyInteractionStatusExampleType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
