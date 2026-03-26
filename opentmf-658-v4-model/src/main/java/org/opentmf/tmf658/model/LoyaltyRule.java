package org.opentmf.tmf658.model;

import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Loyalty rule, containing conditions, event types and actions.
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
public class LoyaltyRule extends LoyaltyRuleUpdate implements ILoyaltyRule {

  /**
   * A reference to the loyalty rule.
   */
  private URI href;

  /**
   * Unique identifier for the loyalty rule.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}