package org.opentmf.tmf708.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.general.model.TestEnvironmentAllocationExecution;

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
public class TestEnvironmentAllocationExecutionDeleteEventPayload implements ITestEnvironmentAllocationExecutionDeleteEventPayload {

  /**
   * REST resource for test environment allocation lifecycle.
   */
  private @Valid TestEnvironmentAllocationExecution testEnvironmentAllocationExecution;
}