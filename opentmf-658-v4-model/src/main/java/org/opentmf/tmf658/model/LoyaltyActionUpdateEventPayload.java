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
public class LoyaltyActionUpdateEventPayload implements ILoyaltyActionUpdateEventPayload {

  /**
   * Contains information on a loyalty action that should be applied should
   * certain conditions be met for a loyalty rule and program.
   */
  private @Valid LoyaltyAction loyaltyAction;
}