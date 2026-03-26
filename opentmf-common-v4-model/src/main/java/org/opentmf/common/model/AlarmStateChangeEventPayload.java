package org.opentmf.common.model;

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
 *   <li>TMF-915: AI Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AlarmStateChangeEventPayload implements IAlarmStateChangeEventPayload {

  /**
   * This resource represents an alarm supporting the information model defined in
   * ITU-T X.733.
   */
  private @Valid Alarm alarm;
}