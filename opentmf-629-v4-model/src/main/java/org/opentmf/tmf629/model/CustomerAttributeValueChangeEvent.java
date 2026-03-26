package org.opentmf.tmf629.model;

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
 *   <li>TMF-629: Customer Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CustomerAttributeValueChangeEvent extends AttributeValueChangeEventBase implements ICustomerAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid CustomerAttributeValueChangeEventPayload event;
}