package org.opentmf.tmf641.model;

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
 *   <li>TMF-641: Service Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceOrderJeopardyEvent extends EventBase implements IServiceOrderJeopardyEvent {

  /**
   * The event data structure.
   */
  private @Valid ServiceOrderJeopardyEventPayload event;
}