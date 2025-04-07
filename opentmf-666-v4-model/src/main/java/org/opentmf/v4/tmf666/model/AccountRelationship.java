package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.TimePeriod;
import org.opentmf.v4.customer.model.AccountRef;

/**
 * Significant connection between accounts. For instance an aggregating account
 * for a list of shop branches each having its own billing account.
 *
 * <p><br/>
 * <strong>Required:</strong> relationshipType, validFor<br/>
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
    defaultImpl = AccountRelationship.class
)
@Required(fields = {"relationshipType", "validFor"})
public class AccountRelationship extends Extensible {

  /**
   * Type of relationship.
   */
  private @SafeText String relationshipType;

  private @Valid AccountRef account;

  /**
   * Validity period of that relationship.
   */
  private @Valid TimePeriod validFor;
}