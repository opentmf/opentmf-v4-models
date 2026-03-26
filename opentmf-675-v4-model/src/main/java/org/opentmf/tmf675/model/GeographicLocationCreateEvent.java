package org.opentmf.tmf675.model;

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
 *   <li>TMF-675: Geographic Location Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class GeographicLocationCreateEvent extends AddressableEventBase implements IGeographicLocationCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid GeographicLocationCreateEventPayload event;
}