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
public class UnAckAlarmsStateChangeEventPayload implements IUnAckAlarmsStateChangeEventPayload {

  /**
   * Task resource for unacknowledge alarms operation.
   */
  private @Valid UnAckAlarms unAckAlarms;
}