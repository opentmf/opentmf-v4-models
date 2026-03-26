package org.opentmf.tmf646.model;

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
 *   <li>TMF-646: Appointment Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class SearchTimeSlotAttributeValueChangeEvent extends AttributeValueChangeEventBase implements ISearchTimeSlotAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid SearchTimeSlotAttributeValueChangeEventPayload event;
}