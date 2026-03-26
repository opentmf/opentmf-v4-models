package org.opentmf.tmf708.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.general.model.TestEnvironmentProvisioningExecution;

/**
 * The event data structure.
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
public class TestEnvironmentProvisioningExecutionStateChangeEventPayload implements ITestEnvironmentProvisioningExecutionStateChangeEventPayload {

  /**
   * REST resource for test environment provisioning lifecycle.
   */
  private @Valid TestEnvironmentProvisioningExecution testEnvironmentProvisioningExecution;
}