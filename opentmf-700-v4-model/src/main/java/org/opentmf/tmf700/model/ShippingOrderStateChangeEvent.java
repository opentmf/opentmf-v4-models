package org.opentmf.tmf700.model;

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
 *   <li>TMF-700: Shipping Order Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ShippingOrderStateChangeEvent extends EventBase implements IShippingOrderStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ShippingOrderStateChangeEventPayload event;
}