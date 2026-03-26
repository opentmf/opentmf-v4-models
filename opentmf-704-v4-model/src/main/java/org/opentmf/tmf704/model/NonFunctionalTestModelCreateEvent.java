package org.opentmf.tmf704.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-704: Test Case Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class NonFunctionalTestModelCreateEvent extends EventBase implements INonFunctionalTestModelCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid NonFunctionalTestModelCreateEventPayload event;
}