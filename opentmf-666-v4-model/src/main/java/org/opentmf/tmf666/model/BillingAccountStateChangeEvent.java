package org.opentmf.tmf666.model;

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
 *   <li>TMF-666: Account Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class BillingAccountStateChangeEvent extends AddressableEventBase implements IBillingAccountStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid BillingAccountStateChangeEventPayload payload;
}