package org.opentmf.tmf706.model;

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
 *   <li>TMF-706: Test Data Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class TestDataSchemaCreateEvent extends EventBase implements ITestDataSchemaCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid TestDataSchemaCreateEventPayload event;
}