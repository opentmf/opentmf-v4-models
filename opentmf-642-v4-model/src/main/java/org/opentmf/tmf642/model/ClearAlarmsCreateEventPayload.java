package org.opentmf.tmf642.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-642: Alarm Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ClearAlarmsCreateEventPayload implements IClearAlarmsCreateEventPayload {

  /**
   * Task resource for clear alarms operation.
   */
  private @Valid ClearAlarms clearAlarms;
}