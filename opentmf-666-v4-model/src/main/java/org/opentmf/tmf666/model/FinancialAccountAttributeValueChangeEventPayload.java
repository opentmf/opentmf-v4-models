package org.opentmf.tmf666.model;

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
 * @author Gökhan Demir
 */
@Getter
@Setter
public class FinancialAccountAttributeValueChangeEventPayload implements IFinancialAccountAttributeValueChangeEventPayload {

  /**
   * An account of money owed by a party to another entity in exchange for goods
   * or services that have been delivered or used. A financial (account receivable
   * account/account payable) aggregates the amounts of one or more party accounts
   * (billing or settlement) owned by a given party. It is a specialization of
   * entity Account.
   */
  private @Valid FinancialAccount financialAccount;
}