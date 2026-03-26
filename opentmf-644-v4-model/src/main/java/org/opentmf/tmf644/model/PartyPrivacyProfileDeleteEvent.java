package org.opentmf.tmf644.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-644: Privacy Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PartyPrivacyProfileDeleteEvent extends EventBase implements IPartyPrivacyProfileDeleteEvent {

  /**
   * The event data structure.
   */
  private @Valid PartyPrivacyProfileDeleteEventPayload event;
}