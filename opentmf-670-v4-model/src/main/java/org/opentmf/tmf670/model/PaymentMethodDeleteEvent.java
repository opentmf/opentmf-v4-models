package org.opentmf.tmf670.model;

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
 *   <li>TMF-670: Payment Method Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PaymentMethodDeleteEvent extends EventBase implements IPaymentMethodDeleteEvent {

  /**
   * The event data structure.
   */
  private @Valid PaymentMethodDeleteEventPayload event;
}