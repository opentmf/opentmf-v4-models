package org.opentmf.tmf663.model;

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
 *   <li>TMF-663: Shopping Cart Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ShoppingCartCreateEvent extends AddressableEventBase implements IShoppingCartCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid ShoppingCartCreateEventPayload event;
}