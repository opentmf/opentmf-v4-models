package org.opentmf.tmf707.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class TestCaseResultCreateEventPayload implements ITestCaseResultCreateEventPayload {

  /**
   * A managed test case result resource.
   */
  private @Valid TestCaseResult testCaseResult;
}