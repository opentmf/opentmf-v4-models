package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * PartyAccount reference. A party account is an arrangement that a party has
 * with an enterprise that provides products to the party.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-654: Prepay Balance Management API</li>
 *   <li>TMF-677: Usage Consumption Management API</li>
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
    defaultImpl = PartyAccountRef.class
)
@Required(fields = {"id"})
public class PartyAccountRef extends EntityRef implements IPartyAccountRef {

  /**
   * Detailed description of the party account.
   */
  private @SafeText String description;

  /**
   * The condition of the account, such as due, paid, in arrears.
   */
  private @SafeText String status;
}