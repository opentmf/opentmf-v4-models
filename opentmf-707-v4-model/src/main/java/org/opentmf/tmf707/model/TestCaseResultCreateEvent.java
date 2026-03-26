package org.opentmf.tmf707.model;

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
 *   <li>TMF-707: Test Result Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class TestCaseResultCreateEvent extends EventBase implements ITestCaseResultCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid TestCaseResultCreateEventPayload event;
}