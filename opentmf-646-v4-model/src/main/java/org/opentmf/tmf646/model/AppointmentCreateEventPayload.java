package org.opentmf.tmf646.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class AppointmentCreateEventPayload implements IAppointmentCreateEventPayload {

  /**
   * An Appointment is an arrangement to do something or meet someone at a
   * particular time, at a place (for face to face appointment) or in a contact
   * medium (for phone appointment).
   */
  private @Valid Appointment appointment;
}