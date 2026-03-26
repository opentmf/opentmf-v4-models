package org.opentmf.tmf654.model;

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
 *   <li>TMF-654: Prepay Balance Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ReserveBalanceCancelEvent extends EventBase implements IReserveBalanceCancelEvent {

  /**
   * The event data structure.
   */
  private @Valid ReserveBalanceCancelEventPayload event;
}