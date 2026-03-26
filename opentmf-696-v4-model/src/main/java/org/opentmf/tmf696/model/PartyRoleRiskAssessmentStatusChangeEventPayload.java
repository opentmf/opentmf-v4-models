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
public class PartyRoleRiskAssessmentStatusChangeEventPayload implements IPartyRoleRiskAssessmentStatusChangeEventPayload {

  /**
   * This is a task resource allowing assessment of the risks associated with a
   * party role.
   */
  private @Valid PartyRoleRiskAssessment partyRoleRiskAssessment;
}