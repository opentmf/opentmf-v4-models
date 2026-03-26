package org.opentmf.tmf642.model;

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
 *   <li>TMF-642: Alarm Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class GroupAlarmsStateChangeEvent extends AddressableEventBase implements IGroupAlarmsStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid GroupAlarmsStateChangeEventPayload event;
}