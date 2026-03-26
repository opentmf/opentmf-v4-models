package org.opentmf.tmf908.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Alarm;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AlarmChangeEventPayload implements IAlarmChangeEventPayload {

  /**
   * This resource represents an alarm supporting the information model defined in
   * ITU-T X.733.
   */
  private @Valid Alarm alarm;
}