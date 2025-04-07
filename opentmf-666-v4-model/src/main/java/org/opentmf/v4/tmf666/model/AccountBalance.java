package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.Money;
import org.opentmf.v4.common.model.TimePeriod;

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
 *   <li>TMF-666: Account Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
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
public class AccountBalance extends Extensible {

  /**
   * Type of the balance : deposit balance, disputed balance, loyalty balance,
   * receivable balance...
   */
  private @SafeText String balanceType;

  /**
   * Balance amount.
   */
  private @Valid Money amount;

  /**
   * Balance validity period.
   */
  private @Valid TimePeriod validFor;
}