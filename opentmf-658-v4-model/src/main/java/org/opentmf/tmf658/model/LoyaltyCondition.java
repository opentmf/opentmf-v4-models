package org.opentmf.tmf658.model;

import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A condition, comprised of a attribute that will be tested against a value.
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
public class LoyaltyCondition extends LoyaltyConditionUpdate implements ILoyaltyCondition {

  /**
   * A reference to the loyalty event type.
   */
  private URI href;

  /**
   * Unique identifier for the loyalty condition.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}