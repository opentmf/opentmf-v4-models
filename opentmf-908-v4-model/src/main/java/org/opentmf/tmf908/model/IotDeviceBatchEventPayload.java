package org.opentmf.tmf908.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class IotDeviceBatchEventPayload implements IIotDeviceBatchEventPayload {

  /**
   * #TODO.
   */
  private @Valid IotDevice iotDevice;
}