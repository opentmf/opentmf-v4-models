package org.opentmf.tmf708.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.general.model.NonFunctionalTestExecution;

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
public class NonFunctionalTestExecutionCreateEventPayload implements INonFunctionalTestExecutionCreateEventPayload {

  /**
   * REST resource for the non-functional test execution lifecycle.
   */
  private @Valid NonFunctionalTestExecution nonFunctionalTestExecution;
}