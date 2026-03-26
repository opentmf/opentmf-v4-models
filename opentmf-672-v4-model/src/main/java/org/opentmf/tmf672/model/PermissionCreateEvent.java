package org.opentmf.tmf672.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AddressableEventBase;

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
public class PermissionCreateEvent extends AddressableEventBase implements IPermissionCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid PermissionCreateEventPayload event;
}