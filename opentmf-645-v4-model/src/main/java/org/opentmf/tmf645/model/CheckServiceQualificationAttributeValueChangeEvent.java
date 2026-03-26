package org.opentmf.tmf645.model;

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
 *   <li>TMF-645: Service Qualification Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CheckServiceQualificationAttributeValueChangeEvent extends AttributeValueChangeEventBase implements ICheckServiceQualificationAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid CheckServiceQualificationAttributeValueChangeEventPayload event;
}