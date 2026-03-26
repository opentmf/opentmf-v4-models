package org.opentmf.tmf670.model;

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
 *   <li>TMF-670: Payment Method Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PaymentMethodAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IPaymentMethodAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid PaymentMethodAttributeValueChangeEventPayload event;
}