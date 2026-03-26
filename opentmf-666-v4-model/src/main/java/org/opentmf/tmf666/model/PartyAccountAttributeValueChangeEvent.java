package org.opentmf.tmf666.model;

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
 *   <li>TMF-666: Account Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PartyAccountAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IPartyAccountAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid PartyAccountAttributeValueChangeEventPayload payload;
}