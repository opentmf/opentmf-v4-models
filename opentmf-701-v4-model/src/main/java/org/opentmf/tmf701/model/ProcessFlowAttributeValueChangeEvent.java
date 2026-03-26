package org.opentmf.tmf701.model;

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
 *   <li>TMF-701: Process Flow Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ProcessFlowAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IProcessFlowAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ProcessFlowAttributeValueChangeEventPayload event;
}