package org.opentmf.tmf709.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class TestScenarioStateChangeEventPayload implements ITestScenarioStateChangeEventPayload {

  /**
   * A managed test scenario resource.
   */
  private @Valid TestScenario testScenario;
}