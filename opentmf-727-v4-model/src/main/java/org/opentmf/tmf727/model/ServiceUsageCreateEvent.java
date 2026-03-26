package org.opentmf.tmf727.model;

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
 *   <li>TMF-727: Service Usage Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceUsageCreateEvent extends EventBase implements IServiceUsageCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid ServiceUsageCreateEventPayload event;
}