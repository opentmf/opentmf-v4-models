package org.opentmf.tmf706.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-706: Test Data Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class TestDataSchemaCreateEventPayload implements ITestDataSchemaCreateEventPayload {

  /**
   * A managed test data schema resource.
   */
  private @Valid TestDataSchema testDataSchema;
}