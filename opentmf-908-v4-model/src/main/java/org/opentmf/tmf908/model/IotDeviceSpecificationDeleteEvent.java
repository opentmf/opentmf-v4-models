package org.opentmf.tmf908.model;

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
 *   <li>TMF-908: IoT Agent and Device Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class IotDeviceSpecificationDeleteEvent extends AddressableEventBase implements IIotDeviceSpecificationDeleteEvent {

  /**
   * The event data structure.
   */
  private @Valid IotDeviceSpecificationDeleteEventPayload event;
}