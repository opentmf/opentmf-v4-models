package org.opentmf.tmf717.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Addressable;
import org.opentmf.common.model.LoyaltyProgramMemberRef;
import org.opentmf.common.model.Money;
import org.opentmf.common.model.TimePeriod;

/**
 * A loyalty balance, containing a balance unit and value.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-717: Customer360 Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class Customer360LoyaltyBalanceVO extends Addressable implements ICustomer360LoyaltyBalanceVO {

  private @Valid LoyaltyProgramMemberRef loyaltyProgramMember;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money quantity;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}