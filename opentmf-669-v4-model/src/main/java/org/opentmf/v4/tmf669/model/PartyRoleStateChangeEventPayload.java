package org.opentmf.v4.tmf669.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class PartyRoleStateChangeEventPayload {

  /**
   * The involved resource data for the event.
   */
  private @Valid PartyRole partyRole;
}