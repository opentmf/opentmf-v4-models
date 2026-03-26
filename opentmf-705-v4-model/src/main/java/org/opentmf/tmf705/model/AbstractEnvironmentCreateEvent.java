package org.opentmf.tmf705.model;

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
 *   <li>TMF-705: Test Environment Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AbstractEnvironmentCreateEvent extends EventBase implements IAbstractEnvironmentCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid AbstractEnvironmentCreateEventPayload event;
}