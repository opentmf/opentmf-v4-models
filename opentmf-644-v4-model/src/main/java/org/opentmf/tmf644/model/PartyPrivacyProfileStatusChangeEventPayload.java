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
public class PartyPrivacyProfileStatusChangeEventPayload implements IPartyPrivacyProfileStatusChangeEventPayload {

  /**
   * A Party Privacy Profile represents the set of Privacy settings defined for a
   * Party.
   */
  private @Valid PartyPrivacyProfile partyPrivacyProfile;
}