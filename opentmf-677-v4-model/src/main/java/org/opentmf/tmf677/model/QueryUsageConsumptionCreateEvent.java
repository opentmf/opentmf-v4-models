package org.opentmf.tmf677.model;

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
 *   <li>TMF-677: Usage Consumption Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class QueryUsageConsumptionCreateEvent extends EventBase implements IQueryUsageConsumptionCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid QueryUsageConsumptionCreateEventPayload event;
}