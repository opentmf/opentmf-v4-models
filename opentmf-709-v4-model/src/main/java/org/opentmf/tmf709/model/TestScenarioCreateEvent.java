package org.opentmf.tmf709.model;

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
 *   <li>TMF-709: Test Scenario Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class TestScenarioCreateEvent extends EventBase implements ITestScenarioCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid TestScenarioCreateEventPayload event;
}