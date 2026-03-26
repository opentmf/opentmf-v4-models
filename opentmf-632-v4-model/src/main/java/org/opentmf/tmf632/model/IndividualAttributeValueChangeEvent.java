package org.opentmf.tmf632.model;

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
 *   <li>TMF-632: Party Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class IndividualAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IIndividualAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid IndividualAttributeValueChangeEventPayload event;
}