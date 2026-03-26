package org.opentmf.tmf658.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class LoyaltyEventTypeCreateEventPayload implements ILoyaltyEventTypeCreateEventPayload {

  /**
   * An event type used to match filter incoming loyalty events.
   */
  private @Valid LoyaltyEventType loyaltyEventType;
}