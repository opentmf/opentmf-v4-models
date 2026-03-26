package org.opentmf.tmf715.model;

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
 *   <li>TMF-715: Warranty Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class WarrantySpecificationAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IWarrantySpecificationAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid WarrantySpecificationAttributeValueChangeEventPayload event;
}