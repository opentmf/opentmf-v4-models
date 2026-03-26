package org.opentmf.tmf668.model;

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
 *   <li>TMF-668: Partnership Type</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PartnershipCreateEvent extends AddressableEventBase implements IPartnershipCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid PartnershipCreateEventPayload event;
}