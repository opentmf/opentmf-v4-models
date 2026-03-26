package org.opentmf.tmf720.model;

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
 *   <li>TMF-720: Digital Identity Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class DigitalIdentityCreateEvent extends EventBase implements IDigitalIdentityCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid DigitalIdentityCreateEventPayload event;
}