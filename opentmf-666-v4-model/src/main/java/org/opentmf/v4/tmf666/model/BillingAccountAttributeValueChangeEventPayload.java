package org.opentmf.v4.tmf666.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class BillingAccountAttributeValueChangeEventPayload {

  /**
   * The involved resource data for the event.
   */
  private @Valid BillingAccount billingAccount;
}