package org.opentmf.tmf672.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class UserRoleAttributeValueChangeEventPayload implements IUserRoleAttributeValueChangeEventPayload {

  /**
   * A UserRole defines access levels to operate over a given function that can be
   * included in an asset.
   */
  private @Valid UserRole userRole;
}