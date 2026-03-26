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
public class LoyaltyProgramMemberCreateEventPayload implements ILoyaltyProgramMemberCreateEventPayload {

  /**
   * A person or group that opts in to a loyalty program.
   */
  private @Valid LoyaltyProgramMember loyaltyProgramMember;
}