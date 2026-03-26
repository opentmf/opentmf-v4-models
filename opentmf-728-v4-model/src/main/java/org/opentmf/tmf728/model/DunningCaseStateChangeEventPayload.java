package org.opentmf.tmf728.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-728: Dunning Case Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class DunningCaseStateChangeEventPayload implements IDunningCaseStateChangeEventPayload {

  /**
   * The DunningCase represents a type of cases open for a customer. Whenever a
   * customer enters the dunning process, a dunning case is linked to his customer
   * account debt and it contains all details pertaining to the debt, such as
   * dunning case rules, interactions… The status of a dunning case evolves
   * according to internal or external events (payments made by the customer,
   * payment schedule granted…).
   */
  private @Valid DunningCase dunningCase;
}