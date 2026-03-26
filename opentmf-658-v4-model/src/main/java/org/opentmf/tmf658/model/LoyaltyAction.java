package org.opentmf.tmf658.model;

import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Contains information on a loyalty action that should be applied should
 * certain conditions be met for a loyalty rule and program.
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
public class LoyaltyAction extends LoyaltyActionUpdate implements ILoyaltyAction {

  /**
   * A reference to the loyalty event type.
   */
  private URI href;

  /**
   * Unique identifier for the loyalty event type.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}