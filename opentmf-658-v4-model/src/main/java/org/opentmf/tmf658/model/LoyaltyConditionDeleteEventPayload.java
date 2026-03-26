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
public class LoyaltyConditionDeleteEventPayload implements ILoyaltyConditionDeleteEventPayload {

  /**
   * A condition, comprised of a attribute that will be tested against a value.
   */
  private @Valid LoyaltyCondition loyaltyCondition;
}