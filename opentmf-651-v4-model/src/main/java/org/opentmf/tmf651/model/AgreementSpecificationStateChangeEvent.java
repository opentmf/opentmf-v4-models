package org.opentmf.tmf651.model;

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
 *   <li>TMF-651: Agreement Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AgreementSpecificationStateChangeEvent extends AddressableEventBase implements IAgreementSpecificationStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid AgreementSpecificationStateChangeEventPayload event;
}