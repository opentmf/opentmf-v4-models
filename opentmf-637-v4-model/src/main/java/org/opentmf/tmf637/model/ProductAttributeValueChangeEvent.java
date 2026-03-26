package org.opentmf.tmf637.model;

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
 *   <li>TMF-637: Product Inventory Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ProductAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IProductAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ProductAttributeValueChangeEventPayload event;
}