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
public class IndividualCreateEvent extends AddressableEventBase implements IIndividualCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid IndividualCreateEventPayload event;
}