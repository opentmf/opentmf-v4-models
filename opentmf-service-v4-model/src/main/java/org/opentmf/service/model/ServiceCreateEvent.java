package org.opentmf.service.model;

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
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-640: Service Activation Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceCreateEvent extends EventBase implements IServiceCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid ServiceCreateEventPayload event;
}