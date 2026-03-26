package org.opentmf.tmf706.model;

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
 *   <li>TMF-706: Test Data Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class TestDataInstanceAttributeValueChangeEvent extends AttributeValueChangeEventBase implements ITestDataInstanceAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid TestDataInstanceAttributeValueChangeEventPayload event;
}