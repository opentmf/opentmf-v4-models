package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Money;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.customer.model.PaymentMethodRef;

/**
 * A party account used for settlement purposes. It includes a description of
 * the bill structure (frequency, presentation media, format and so on). It is a
 * specialization of entity PartyAccount.
 * <br/>Skipped properties: id,href,accountBalance.
 *
 * <p><br/>
 * <strong>Required:</strong> name, relatedParty<br/>
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
    defaultImpl = SettlementAccountUpdate.class
)
@Required(fields = {"name", "relatedParty"})
public class SettlementAccountUpdate extends BillFormatCreate {

  /**
   * A categorization of an account, such as individual, joint, and so forth,
   * whose instances share some of the same characteristics. Note: for flexibility
   * we use a String here but an implementation may use an enumeration with a
   * limited list of valid values.
   */
  private @SafeText String accountType;

  /**
   * Date of last modification of the account.
   */
  private OffsetDateTime lastModified;

  /**
   * The condition of the account, such as due, paid, in arrears.
   */
  private @SafeText String paymentStatus;

  /**
   * Contains the lifecycle state such as: Active, Closed, Suspended and so on.
   */
  private @SafeText String state;

  /**
   * List of: Significant connection between accounts. For instance an aggregating
   * account for a list of shop branches each having its own billing account.
   */
  @JsonProperty("accountRelationship")
  private List<@Valid AccountRelationship> accountRelationships;

  private @Valid BillStructure billStructure;

  /**
   * List of: An individual or an organization used as a contact point for a given
   * account and accessed via some contact medium.
   */
  @JsonProperty("contact")
  private List<@Valid Contact> contacts;

  /**
   * The maximum amount of money that may be charged on an account.
   */
  private @Valid Money creditLimit;

  private @Valid PaymentMethodRef defaultPaymentMethod;

  private @Valid FinancialAccountRef financialAccount;

  /**
   * List of: Defines a plan for payment (when a party wants to spread his
   * payments).
   */
  @JsonProperty("paymentPlan")
  private List<@Valid PaymentPlan> paymentPlans;

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private @Size(min = 1) List<@Valid RelatedParty> relatedParties;

  /**
   * List of: Proof of freedom from taxes imposed by a taxing jurisdiction.
   */
  @JsonProperty("taxExemption")
  private List<@Valid AccountTaxExemption> taxExemptions;
}