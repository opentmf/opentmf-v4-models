package org.opentmf.tmf671.model;

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
 *   <li>TMF-671: Promotion Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PromotionDeleteEvent extends EventBase implements IPromotionDeleteEvent {

  /**
   * The event data structure.
   */
  private @Valid PromotionDeleteEventPayload event;
}