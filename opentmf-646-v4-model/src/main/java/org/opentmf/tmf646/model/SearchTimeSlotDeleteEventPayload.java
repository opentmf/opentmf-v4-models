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
public class SearchTimeSlotDeleteEventPayload implements ISearchTimeSlotDeleteEventPayload {

  /**
   * This task resource is used to retrieve available time slots. One of this
   * available time slot is after used to create or reschedule an appointment.
   */
  private @Valid SearchTimeSlot searchTimeSlot;
}