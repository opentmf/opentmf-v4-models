package org.opentmf.tmf708.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.general.model.TestSuiteExecution;

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
public class TestSuiteExecutionStateChangeEventPayload implements ITestSuiteExecutionStateChangeEventPayload {

  /**
   * REST resource for the test suite execution lifecycle.
   */
  private @Valid TestSuiteExecution testSuiteExecution;
}