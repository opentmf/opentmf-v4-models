package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.PaymentMethodRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A history of the following operations performed on the bucket: TopupBalance,
 * AdjustBalance and TransferBalance.
 *
 * <p><br/>
 * <strong>Required:</strong> receiverLogicalResource, status<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-654: Prepay Balance Management API</li>
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
    defaultImpl = BalanceActionHistory.class
)
@Required(fields = {"receiverLogicalResource", "status"})
public class BalanceActionHistory extends TransferBalance implements IBalanceActionHistory {

  /**
   * Valid values for the Balance Adjust types
   * <br/><p>Recommended values: recurring, oneTime.
   *
   * @see org.opentmf.tmf654.model.AdjustType
   */
  private @SafeText String adjustType;

  /**
   * Related Entity reference. A related balance topup defines a relationship via
   * a role to another balance topup. Used in the PrepayBalanceManagement API to
   * track child topups that are related to the parent (initiating balance topup
   * resource). PrepayBalanceManagement defines the child role.
   */
  private @Valid RelatedTopupBalance balanceTopup;

  /**
   * Indicates if the topup requested is an autotopup (to be processed
   * periodically).
   */
  private Boolean isAutoTopup;

  /**
   * For autotopup indicates the number of occurrences of the period the recharge
   * operation must be executed. If not included then no limit is set to stop the
   * executionof the topup every period.
   */
  private Integer numberOfPeriods;

  /**
   * PaymentMethod reference. A payment method defines a specific mean of payment
   * (e.g. direct debit).
   */
  private @Valid PaymentMethodRef paymentMethod;

  /**
   * Valid values for this type
   * <br/><p>Recommended values: weekly, fortnightly, monthly.
   *
   * @see org.opentmf.tmf654.model.RecurringPeriodType
   */
  private @SafeText String recurringPeriod;

  /**
   * Identifier for a voucher when the topup can be performed by this means.
   */
  private @SafeText String voucher;
}