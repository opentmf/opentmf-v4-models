package org.opentmf.tmf657.model;

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
 *   <li>TMF-657: Service Quality Management Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceLevelObjectiveAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IServiceLevelObjectiveAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ServiceLevelObjectiveAttributeValueChangeEventPayload event;
}