package org.opentmf.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * An account of money owed by a party to another entity in exchange for goods
 * or services that have been delivered or used. A financial (account receivable
 * account/account payable) aggregates the amounts of one or more party accounts
 * (billing or settlement) owned by a given party. It is a specialization of
 * entity Account.
 * <br/>Skipped properties: id,href.
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
    defaultImpl = FinancialAccountCreate.class
)
@Required(fields = {"name"})
public class FinancialAccountCreate extends FinancialAccountUpdate implements IFinancialAccountCreate {

  /**
   * Date of last modification of the account.
   */
  private OffsetDateTime lastModified;
}