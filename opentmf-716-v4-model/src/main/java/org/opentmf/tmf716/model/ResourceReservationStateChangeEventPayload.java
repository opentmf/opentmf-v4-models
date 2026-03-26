package org.opentmf.tmf716.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class ResourceReservationStateChangeEventPayload implements IResourceReservationStateChangeEventPayload {

  private @Valid ResourceReservation resourceReservation;
}