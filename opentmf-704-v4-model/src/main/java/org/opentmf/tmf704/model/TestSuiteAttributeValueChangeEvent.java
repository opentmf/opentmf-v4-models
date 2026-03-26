package org.opentmf.tmf704.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttributeValueChangeEventBase;

/**
 * The notification data structure.
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
public class TestSuiteAttributeValueChangeEvent extends AttributeValueChangeEventBase implements ITestSuiteAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid TestSuiteAttributeValueChangeEventPayload event;
}