package org.opentmf.v4.tmf669.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.common.model.AddressableEventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-669: Party Role Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class PartyRoleStateChangeEvent extends AddressableEventBase {

  /**
   * The event payload linked to the involved resource object.
   */
  private @Valid PartyRoleStateChangeEventPayload event;
}