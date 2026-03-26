package org.opentmf.tmf711.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.partner.model.Shipment;

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
public class ShipmentAttributeValueChangeEventPayload implements IShipmentAttributeValueChangeEventPayload {

  private @Valid Shipment shipment;
}