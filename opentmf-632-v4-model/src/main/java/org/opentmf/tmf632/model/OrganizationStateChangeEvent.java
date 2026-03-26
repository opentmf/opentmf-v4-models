package org.opentmf.tmf632.model;

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
 *   <li>TMF-632: Party Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class OrganizationStateChangeEvent extends AddressableEventBase implements IOrganizationStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid OrganizationStateChangeEventPayload event;
}