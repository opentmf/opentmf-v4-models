package org.opentmf.tmf621.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AddressableEventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-621: Trouble Ticket Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class TroubleTicketDeleteEvent extends AddressableEventBase implements ITroubleTicketDeleteEvent {

  /**
   * The event data structure.
   */
  private @Valid TroubleTicketDeleteEventPayload event;
}