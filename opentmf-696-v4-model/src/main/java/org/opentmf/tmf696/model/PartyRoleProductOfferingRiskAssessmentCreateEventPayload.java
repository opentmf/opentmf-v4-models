package org.opentmf.tmf696.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-696: Risk Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PartyRoleProductOfferingRiskAssessmentCreateEventPayload implements IPartyRoleProductOfferingRiskAssessmentCreateEventPayload {

  /**
   * This is a task resource allowing assessment of the risks associated with a
   * party or party role that considers acquiring a specific product offering.
   */
  private @Valid PartyRoleProductOfferingRiskAssessment partyRoleProductOfferingRiskAssessment;
}