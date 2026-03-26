package org.opentmf.tmf705.model;

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
 *   <li>TMF-705: Test Environment Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AbstractEnvironmentAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IAbstractEnvironmentAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid AbstractEnvironmentAttributeValueChangeEventPayload event;
}