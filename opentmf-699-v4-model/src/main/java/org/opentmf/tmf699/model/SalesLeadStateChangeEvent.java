package org.opentmf.tmf699.model;

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
 *   <li>TMF-699: Sales Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class SalesLeadStateChangeEvent extends AddressableEventBase implements ISalesLeadStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid SalesLeadStateChangeEventPayload event;
}