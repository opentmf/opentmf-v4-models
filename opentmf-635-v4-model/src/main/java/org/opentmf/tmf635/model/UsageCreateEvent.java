package org.opentmf.tmf635.model;

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
 *   <li>TMF-635: Usage Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class UsageCreateEvent extends EventBase implements IUsageCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid UsageCreateEventPayload event;
}