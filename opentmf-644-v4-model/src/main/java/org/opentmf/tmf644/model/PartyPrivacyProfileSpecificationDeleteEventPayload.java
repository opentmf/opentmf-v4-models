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
public class PartyPrivacyProfileSpecificationDeleteEventPayload implements IPartyPrivacyProfileSpecificationDeleteEventPayload {

  /**
   * Party Privacy Profile Specification serves as a template for creating Privacy
   * Profiles. The specification defines characteristics for the profile. For
   * example there might be a profile specification for residential customers, and
   * a different specification for partners.
   */
  private @Valid PartyPrivacyProfileSpecification partyPrivacyProfileSpecification;
}