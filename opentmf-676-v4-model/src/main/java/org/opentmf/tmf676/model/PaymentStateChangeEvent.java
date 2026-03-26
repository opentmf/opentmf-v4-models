package org.opentmf.tmf676.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AddressableEventBase;

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
public class PaymentStateChangeEvent extends AddressableEventBase implements IPaymentStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid PaymentStateChangeEventPayload event;
}