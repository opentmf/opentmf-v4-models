package org.opentmf.common.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The notification data structure.
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
public class AlarmAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IAlarmAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid AlarmAttributeValueChangeEventPayload event;
}