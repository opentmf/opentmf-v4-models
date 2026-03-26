package org.opentmf.tmf678.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.BillingAccountRef;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.FinancialAccountRef;
import org.opentmf.common.model.Money;
import org.opentmf.common.model.PaymentMethodRef;
import org.opentmf.common.model.RelatedPartyRef;
import org.opentmf.common.model.TaxItem;
import org.opentmf.common.model.TimePeriod;
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
    defaultImpl = CustomerBill.class
)
public class CustomerBill extends Entity implements ICustomerBill {

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money amountDue;

  /**
   * List of: The applied payment is the result of lettering process. It enables
   * to assign automatically or manually part of incoming payment amount to a
   * bill.
   */
  @JsonProperty("appliedPayment")
  private List<@Valid AppliedPayment> appliedPayments;

  /**
   * Bill date.
   */
  private OffsetDateTime billDate;

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("billDocument")
  private List<@Valid AttachmentRefOrValue> billDocuments;

  /**
   * Bill reference known by the customer or the party and displayed on the bill.
   * Could be different from the id.
   */
  private @SafeText String billNo;

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

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
   * AccountReceivable reference. An account of money owed by a party to another
   * entity in exchange for goods or services that have been delivered or used. An
   * account receivable aggregates the amounts of one or more party accounts
   * (billing or settlement) owned by a given party.
   */
  private @Valid FinancialAccountRef financialAccount;

  /**
   * Date of bill last update.
   */
  private OffsetDateTime lastUpdate;

  /**
   * ). Approximate date of the next bill production given for information (only
   * used for onCycle bill).
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
   * List of: RelatedParty reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedPartyRef> relatedParties;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money remainingAmount;

  /**
   * onCycle (a bill can be created as a result of a cycle run) or offCycle (a
   * bill can be created as a result of other events such as customer request or
   * account close).
   */
  private @SafeText String runType;

  /**
   * <p>Recommended values: new, onHold, validated, sent, partiallyPaid, settled.
   *
   * @see org.opentmf.tmf678.model.StateValue
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

  /**
   * List of: A tax item is created for each tax rate and tax type used in the
   * bill.
   */
  @JsonProperty("taxItem")
  private List<@Valid TaxItem> taxItems;
}