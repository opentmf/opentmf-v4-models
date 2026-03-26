package org.opentmf.tmf652.model;

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
 *   <li>TMF-652: Resource Order Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ResourceOrderAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IResourceOrderAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ResourceOrderAttributeValueChangeEventPayload event;
}