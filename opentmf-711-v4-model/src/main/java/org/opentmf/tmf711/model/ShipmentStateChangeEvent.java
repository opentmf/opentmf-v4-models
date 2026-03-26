package org.opentmf.tmf711.model;

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
 *   <li>TMF-711: Shipment Management Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ShipmentStateChangeEvent extends EventBase implements IShipmentStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ShipmentStateChangeEventPayload event;
}