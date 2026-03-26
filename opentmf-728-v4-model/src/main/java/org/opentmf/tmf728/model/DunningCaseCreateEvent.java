package org.opentmf.tmf728.model;

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
 *   <li>TMF-728: Dunning Case Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class DunningCaseCreateEvent extends EventBase implements IDunningCaseCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid DunningCaseCreateEventPayload event;
}