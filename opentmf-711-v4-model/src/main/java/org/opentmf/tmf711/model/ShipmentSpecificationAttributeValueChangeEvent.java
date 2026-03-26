package org.opentmf.tmf711.model;

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
 *   <li>TMF-711: Shipment Management Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ShipmentSpecificationAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IShipmentSpecificationAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ShipmentSpecificationAttributeValueChangeEventPayload event;
}