package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Account used for billing or for settlement purposes concerning a given party
 * (an organization or an individual). It is a specialization of entity Account.
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
    defaultImpl = PartyAccount.class
)
@Required(fields = {"name", "relatedParty"})
public class PartyAccount extends BillingAccountCreate {

  /**
   * Unique identifier of the account.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Unique reference of the account.
   */
  private URI href;
}