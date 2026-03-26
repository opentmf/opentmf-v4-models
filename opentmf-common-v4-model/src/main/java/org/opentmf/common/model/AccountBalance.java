package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Balances linked to the account.
 *
 * <p><br/>
 * <strong>Required:</strong> amount, balanceType, validFor<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-666: Account Management API</li>
 *   <li>TMF-678: Customer Bill Management API</li>
 *   <li>TMF-728: Dunning Case Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = AccountBalance.class
)
@Required(fields = {"amount", "balanceType", "validFor"})
public class AccountBalance extends Entity implements IAccountBalance {

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money amount;

  /**
   * Type of the balance : deposit balance, disputed balance, loyalty balance,
   * receivable balance...
   */
  private @SafeText String balanceType;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}