package org.opentmf.tmf646.model;

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
 *   <li>TMF-646: Appointment Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AppointmentDeleteEvent extends AddressableEventBase implements IAppointmentDeleteEvent {

  /**
   * The event data structure.
   */
  private @Valid AppointmentDeleteEventPayload event;
}