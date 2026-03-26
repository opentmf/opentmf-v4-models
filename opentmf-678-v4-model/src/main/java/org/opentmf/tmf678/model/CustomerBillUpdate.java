package org.opentmf.tmf678.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The billing account receives all charges (recurring, one time and usage) of
 * the offers and products assigned to it during order process. Periodically
 * according to billing cycle specifications attached to the billing account or
 * as a result of an event, a customer bill (aka invoice) is produced. This
 * customer bill concerns different related parties which play a role on it :
 * for example, a customer bill is produced by an operator, is sent to a bill
 * receiver and has to be paid by a payer.
 * <br/>A payment method could be assigned to the customer bill to build the
 * call of payment. Lettering process enables to assign automatically or
 * manually incoming amount from payments to customer bills (payment items).
 * <br/>A tax item is created for each tax rate used in the customer bill.
 * <br/>The financial account represents a financial entity which records all
 * customer’s accounting events : payment amount are recorded as credit and
 * invoices amount are recorded as debit. It gives the customer overall balance
 * (account balance).
 * <br/>The customer bill is linked to one or more documents that can be
 * downloaded via a provided url.
 * <br/>Skipped properties:
 * id,href,amountDue,appliedPayment,billDate,billDocument,billNo,billingAccount,billingPeriod,category,financialAccount,lastUpdate,nextBillDate,paymentDueDate,paymentMethod,relatedParty,remainingAmount,runType,taxExcludedAmount,taxIncludedAmount,taxItem.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-678: Customer Bill Management API</li>
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
    defaultImpl = CustomerBillUpdate.class
)
public class CustomerBillUpdate extends Extensible implements ICustomerBillUpdate {

  /**
   * <p>Recommended values: new, onHold, validated, sent, partiallyPaid, settled.
   *
   * @see org.opentmf.tmf678.model.StateValue
   */
  private @SafeText String state;
}