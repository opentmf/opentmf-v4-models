package org.opentmf.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AccountBalance;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.partner.model.AccountUpdateBase;

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
 * @author Gökhan Demir
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
public class FinancialAccountUpdate extends AccountUpdateBase implements IFinancialAccountUpdate {

  /**
   * List of: Balances linked to the account.
   */
  @JsonProperty("accountBalance")
  private List<@Valid AccountBalance> accountBalances;

  /**
   * List of: Proof of freedom from taxes imposed by a taxing jurisdiction.
   */
  @JsonProperty("taxExemption")
  private List<@Valid AccountTaxExemption> taxExemptions;
}