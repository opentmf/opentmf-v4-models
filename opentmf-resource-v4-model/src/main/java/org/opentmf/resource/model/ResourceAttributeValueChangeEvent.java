package org.opentmf.resource.model;

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
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ResourceAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IResourceAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ResourceAttributeValueChangeEventPayload event;
}