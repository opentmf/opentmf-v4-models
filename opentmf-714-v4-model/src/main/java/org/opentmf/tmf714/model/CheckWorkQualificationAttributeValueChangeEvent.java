package org.opentmf.tmf714.model;

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
 *   <li>TMF-714: Work Qualification Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CheckWorkQualificationAttributeValueChangeEvent extends AttributeValueChangeEventBase implements ICheckWorkQualificationAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid CheckWorkQualificationAttributeValueChangeEventPayload event;
}