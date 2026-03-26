package org.opentmf.tmf704.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class TestSuiteDeleteEventPayload implements ITestSuiteDeleteEventPayload {

  /**
   * A managed test suite resource.
   */
  private @Valid TestSuite testSuite;
}