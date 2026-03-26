package org.opentmf.tmf711.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.partner.model.ShipmentSpecification;

/**
 * The event data structure.
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
public class ShipmentSpecificationAttributeValueChangeEventPayload implements IShipmentSpecificationAttributeValueChangeEventPayload {

  /**
   * Definition of the nature of a Shipment. For example, could be a standard
   * ground delivery, overnight express with signature required by an adult, etc.
   */
  private @Valid ShipmentSpecification shipmentSpecification;
}