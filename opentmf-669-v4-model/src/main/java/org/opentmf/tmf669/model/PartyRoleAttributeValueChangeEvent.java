package org.opentmf.tmf669.model;

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
 *   <li>TMF-669: Party Role Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PartyRoleAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IPartyRoleAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid PartyRoleAttributeValueChangeEventPayload event;
}