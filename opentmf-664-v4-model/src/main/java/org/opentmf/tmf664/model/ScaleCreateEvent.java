package org.opentmf.tmf664.model;

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
 *   <li>TMF-664: Resource Function Activation Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ScaleCreateEvent extends EventBase implements IScaleCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid ScaleCreateEventPayload event;
}