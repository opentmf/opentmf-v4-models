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
public class LoyaltyProgramPartnerUpdateEvent extends EventBase implements ILoyaltyProgramPartnerUpdateEvent {

  /**
   * The event data structure.
   */
  private @Valid LoyaltyProgramPartnerUpdateEventPayload event;
}