package org.opentmf.tmf621.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class TroubleTicketResolvedEventPayload implements ITroubleTicketResolvedEventPayload {

  /**
   * A trouble ticket is a record of an issue that is created, tracked, and
   * managed by a trouble ticket management system.
   */
  private @Valid TroubleTicket troubleTicket;
}