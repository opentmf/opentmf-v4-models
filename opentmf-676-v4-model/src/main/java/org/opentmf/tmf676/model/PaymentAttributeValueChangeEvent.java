package org.opentmf.tmf676.model;

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
 *   <li>TMF-676: Payment Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PaymentAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IPaymentAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid PaymentAttributeValueChangeEventPayload event;
}