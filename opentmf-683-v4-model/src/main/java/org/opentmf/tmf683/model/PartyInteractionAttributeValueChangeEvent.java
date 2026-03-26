package org.opentmf.tmf683.model;

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
 *   <li>TMF-683: Party Interaction Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PartyInteractionAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IPartyInteractionAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid PartyInteractionAttributeValueChangeEventPayload event;
}