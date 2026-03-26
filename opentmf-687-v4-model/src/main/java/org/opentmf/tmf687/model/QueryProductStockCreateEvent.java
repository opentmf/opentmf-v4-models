package org.opentmf.tmf687.model;

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
 *   <li>TMF-687: Stock Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class QueryProductStockCreateEvent extends EventBase implements IQueryProductStockCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid QueryProductStockCreateEventPayload event;
}