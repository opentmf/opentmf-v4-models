package org.opentmf.tmf622.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttributeValueChangeEventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CancelProductOrderInformationRequiredEvent extends AttributeValueChangeEventBase implements ICancelProductOrderInformationRequiredEvent {

  /**
   * The event data structure.
   */
  private @Valid CancelProductOrderInformationRequiredEventPayload event;
}