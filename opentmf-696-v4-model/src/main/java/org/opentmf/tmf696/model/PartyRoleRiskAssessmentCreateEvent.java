package org.opentmf.tmf696.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EventBase;

/**
 * The notification data structure.
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
public class PartyRoleRiskAssessmentCreateEvent extends EventBase implements IPartyRoleRiskAssessmentCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid PartyRoleRiskAssessmentCreateEventPayload event;
}