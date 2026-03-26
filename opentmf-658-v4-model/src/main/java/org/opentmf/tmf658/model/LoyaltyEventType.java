package org.opentmf.tmf658.model;

import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Addressable;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An event type used to match filter incoming loyalty events.
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
public class LoyaltyEventType extends Addressable implements ILoyaltyEventType {

  /**
   * The topic to which the event type relates.
   */
  private @SafeText String eventTopic;

  /**
   * The type of loyalty event expected to trigger the loyalty rule evaluation,
   * e.g. a CustomerOrder or an Invoice. The eventType should be unique to prevent
   * existing resources not being reused. An eventType that already exists will
   * result in a 422 error.
   */
  private @SafeText String eventType;
}