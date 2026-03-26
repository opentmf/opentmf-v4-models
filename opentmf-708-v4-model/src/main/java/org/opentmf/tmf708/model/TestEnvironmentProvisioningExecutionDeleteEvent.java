package org.opentmf.tmf708.model;

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
 *   <li>TMF-708: Test Execution Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class TestEnvironmentProvisioningExecutionDeleteEvent extends EventBase implements ITestEnvironmentProvisioningExecutionDeleteEvent {

  /**
   * The event data structure.
   */
  private @Valid TestEnvironmentProvisioningExecutionDeleteEventPayload event;
}