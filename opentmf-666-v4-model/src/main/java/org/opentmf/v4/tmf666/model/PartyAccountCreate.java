package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Account used for billing or for settlement purposes concerning a given party
 * (an organization or an individual). It is a specialization of entity Account.
 * <br/>Skipped properties: id,href.
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
    defaultImpl = PartyAccountCreate.class
)
@Required(fields = {"name", "relatedParty"})
public class PartyAccountCreate extends BillingAccountUpdate {

  /**
   * List of: Balances linked to the account.
   */
  @JsonProperty("accountBalance")
  private List<@Valid AccountBalance> accountBalances;
}