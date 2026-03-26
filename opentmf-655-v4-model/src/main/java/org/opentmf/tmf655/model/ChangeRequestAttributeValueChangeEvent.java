package org.opentmf.tmf655.model;

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
 *   <li>TMF-655: Change Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ChangeRequestAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IChangeRequestAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ChangeRequestAttributeValueChangeEventPayload event;
}