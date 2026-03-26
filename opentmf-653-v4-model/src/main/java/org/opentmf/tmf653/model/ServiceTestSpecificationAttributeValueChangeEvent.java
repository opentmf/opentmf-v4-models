package org.opentmf.tmf653.model;

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
 *   <li>TMF-653: Service Test Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceTestSpecificationAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IServiceTestSpecificationAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ServiceTestSpecificationAttributeValueChangeEventPayload event;
}