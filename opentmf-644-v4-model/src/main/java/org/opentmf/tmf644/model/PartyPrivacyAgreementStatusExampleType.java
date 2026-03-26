package org.opentmf.tmf644.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the status of party privacy profile agreement (for
 * example: intialized, inProgress, rejected, pendingUpdate, validated).
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
public enum PartyPrivacyAgreementStatusExampleType {

  INITIALIZED("initialized"),
  IN_PROGRESS("inProgress"),
  REJECTED("rejected"),
  PENDING_UPDATE("pendingUpdate"),
  VALIDATED("validated");

  private final String value;

  PartyPrivacyAgreementStatusExampleType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, PartyPrivacyAgreementStatusExampleType> REVERSE_MAP = new HashMap<>();

  static {
    for (PartyPrivacyAgreementStatusExampleType partyPrivacyAgreementStatusExampleType : values()) {
      REVERSE_MAP.put(partyPrivacyAgreementStatusExampleType.getValue(), partyPrivacyAgreementStatusExampleType);
    }
  }

  @JsonCreator
  public static PartyPrivacyAgreementStatusExampleType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
