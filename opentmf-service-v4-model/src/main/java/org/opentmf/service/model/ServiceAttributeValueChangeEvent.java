package org.opentmf.service.model;

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
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-640: Service Activation Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IServiceAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ServiceAttributeValueChangeEventPayload event;
}