package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Money;
import org.opentmf.v4.common.model.RelatedParty;

/**
 * An account of money owed by a party to another entity in exchange for goods
 * or services that have been delivered or used. A financial (account receivable
 * account/account payable) aggregates the amounts of one or more party accounts
 * (billing or settlement) owned by a given party. It is a specialization of
 * entity Account.
 * <br/>Skipped properties: id,href,lastModified.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
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
    defaultImpl = FinancialAccountUpdate.class
)
@Required(fields = {"name"})
public class FinancialAccountUpdate extends BillFormatCreate {

  /**
   * A categorization of an account, such as individual, joint, and so forth,
   * whose instances share some of the same characteristics. Note: for flexibility
   * we use a String here but an implementation may use an enumeration with a
   * limited list of valid values.
   */
  private @SafeText String accountType;

  /**
   * Contains the lifecycle state such as: Active, Closed, Suspended and so on.
   */
  private @SafeText String state;

  /**
   * List of: Balances linked to the account.
   */
  @JsonProperty("accountBalance")
  private List<@Valid AccountBalance> accountBalances;

  /**
   * List of: Significant connection between accounts. For instance an aggregating
   * account for a list of shop branches each having its own billing account.
   */
  @JsonProperty("accountRelationship")
  private List<@Valid AccountRelationship> accountRelationships;

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

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * List of: Proof of freedom from taxes imposed by a taxing jurisdiction.
   */
  @JsonProperty("taxExemption")
  private List<@Valid AccountTaxExemption> taxExemptions;
}