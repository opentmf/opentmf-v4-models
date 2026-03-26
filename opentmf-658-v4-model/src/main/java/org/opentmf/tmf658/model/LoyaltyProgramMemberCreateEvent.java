package org.opentmf.tmf658.model;

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
 *   <li>TMF-658: Loyalty</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class LoyaltyProgramMemberCreateEvent extends EventBase implements ILoyaltyProgramMemberCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid LoyaltyProgramMemberCreateEventPayload event;
}