package org.opentmf.tmf716.model;

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
 *   <li>TMF-716: ResourceReservation</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ResourceReservationCreateEvent extends EventBase implements IResourceReservationCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid ResourceReservationCreateEventPayload event;
}