package org.opentmf.tmf644.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
@Getter
@Setter
public class PartyPrivacyAgreementCreateEventPayload implements IPartyPrivacyAgreementCreateEventPayload {

  /**
   * A specific type of agreement that formalizes the privacy profiles requested
   * for a party.
   */
  private @Valid PartyPrivacyAgreement partyPrivacyAgreement;
}