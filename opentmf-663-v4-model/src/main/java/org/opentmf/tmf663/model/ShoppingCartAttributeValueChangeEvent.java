package org.opentmf.tmf663.model;

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
 *   <li>TMF-663: Shopping Cart Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ShoppingCartAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IShoppingCartAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ShoppingCartAttributeValueChangeEventPayload event;
}