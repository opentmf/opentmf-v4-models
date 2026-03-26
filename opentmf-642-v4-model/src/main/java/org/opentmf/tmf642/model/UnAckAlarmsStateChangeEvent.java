package org.opentmf.tmf642.model;

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
 *   <li>TMF-642: Alarm Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class UnAckAlarmsStateChangeEvent extends AddressableEventBase implements IUnAckAlarmsStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid UnAckAlarmsStateChangeEventPayload event;
}