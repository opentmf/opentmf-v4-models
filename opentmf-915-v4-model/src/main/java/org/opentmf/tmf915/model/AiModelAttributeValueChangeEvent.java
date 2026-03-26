package org.opentmf.tmf915.model;

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
 *   <li>TMF-915: AI Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AiModelAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IAiModelAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid AiModelAttributeValueChangeEventPayload event;
}