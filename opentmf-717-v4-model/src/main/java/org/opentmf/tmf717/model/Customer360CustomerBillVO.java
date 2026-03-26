package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.Money;
import org.opentmf.common.model.PaymentMethodRef;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The customer bill. Can be a regular recurring bill or an extra bill on demand
 * by the customer or the csp.
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = Customer360CustomerBillVO.class
)
public class Customer360CustomerBillVO extends Entity implements ICustomer360CustomerBillVO {

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money amountDue;

  /**
   * ....
   */
  private @Valid BillCycleRef billCycle;

  /**
   * Bill date, external customer view (in consequence: different to the
   * production date of the bill).
   */
  private OffsetDateTime billDate;

  /**
   * Bill reference known by the customer or the party and displayed on the bill.
   * Could be different from the id.
   */
  private @SafeText String billNo;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod billingPeriod;

  /**
   * Category of the bill produced : normal, duplicate, interim, last, trial
   * customer or credit note for example.
   */
  private @SafeText String category;

  /**
   * Date of bill last update.
   */
  private OffsetDateTime lastUpdate;

  /**
   * ). Approximate date of the next bill production given for information (only
   * used/meaningful for on cycle / regular bills).
   */
  private OffsetDateTime nextBillDate;

  /**
   * Date at which the amount due should have been paid.
   */
  private OffsetDateTime paymentDueDate;

  /**
   * PaymentMethod reference. A payment method defines a specific mean of payment
   * (e.g. direct debit).
   */
  private @Valid PaymentMethodRef paymentMethod;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money remainingAmount;

  /**
   * Recommended Enumeration Type (not formal forced in standard): Valid values
   * for the runType of a bill. The bill could be produced in a regular bill cycle
   * 'onCycle'. Otherwise the bill is produced on a request (e.g. customer
   * request). This could be indicated by 'offCycle'
   * <br/><p>Recommended values: onCycle, offCycle.
   *
   * @see org.opentmf.tmf717.model.CustomerBillRunType
   */
  private @SafeText String runType;

  /**
   * Recommended Enumeration Type (not formal forced in standard): Valid values
   * for the lifecycle state of the bill: new = 'bill is ready to validate or to
   * sent', validated = 'bill is checked (manual / automatic)', sent = 'bill is
   * sent with the channel defined in the billingaccount', settled = 'bill is
   * payed', partiallySettled = 'bill is partially payed', onHold = 'bill will not
   * be in further processing until open issues connected to the bill are solved'
   * <br/><p>Recommended values: new, onHold, validated, sent, settled,
   * partiallyPaid.
   *
   * @see org.opentmf.tmf717.model.CustomerBillStateType
   */
  private @SafeText String state;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money taxExcludedAmount;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money taxIncludedAmount;
}