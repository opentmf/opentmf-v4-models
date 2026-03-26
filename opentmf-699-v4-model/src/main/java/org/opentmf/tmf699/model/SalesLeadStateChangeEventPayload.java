package org.opentmf.tmf699.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class SalesLeadStateChangeEventPayload implements ISalesLeadStateChangeEventPayload {

  /**
   * A Sales Lead is the identification of a person or organization that has an
   * interest in the goods and/or services provided in the prospect of them
   * becoming Customers with one or more Subscriptions.
   */
  private @Valid SalesLead salesLead;
}