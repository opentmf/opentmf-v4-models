package org.opentmf.tmf713.model;

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
 *   <li>TMF-713: Work Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class WorkAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IWorkAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid WorkAttributeValueChangeEventPayload event;
}