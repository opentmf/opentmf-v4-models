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
public class PermissionDeleteEventPayload implements IPermissionDeleteEventPayload {

  /**
   * The Permission resource represents the entitlement given by an individual
   * (granter) to another individual (user) to get access to a set of his owned
   * manageable assets. One single permission resource can hold information
   * referring to privileges granted for multiple manageable assets.
   */
  private @Valid Permission permission;
}