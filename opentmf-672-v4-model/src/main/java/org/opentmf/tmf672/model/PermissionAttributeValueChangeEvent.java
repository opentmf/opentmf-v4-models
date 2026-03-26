package org.opentmf.tmf672.model;

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
 *   <li>TMF-672: User Role Permission Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PermissionAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IPermissionAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid PermissionAttributeValueChangeEventPayload event;
}