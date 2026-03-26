package org.opentmf.tmf629.model;

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
 *   <li>TMF-629: Customer Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CustomerDeleteEvent extends AddressableEventBase implements ICustomerDeleteEvent {

  /**
   * The event data structure.
   */
  private @Valid CustomerDeleteEventPayload event;
}