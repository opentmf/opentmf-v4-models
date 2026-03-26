package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AccountRelationship;
import org.opentmf.common.model.Money;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Generic Account structure used to define commonalities between sub concepts
 * of PartyAccount and Financial Account.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-717: Customer360 Management API</li>
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
    defaultImpl = Customer360AccountVO.class
)
@Required(fields = {"name"})
public class Customer360AccountVO extends NamedEntity implements ICustomer360AccountVO {

  /**
   * List of: Significant connection between accounts. For instance an aggregating
   * account for a list of shop branches each having its own billing account.
   */
  @JsonProperty("accountRelationship")
  private List<@Valid AccountRelationship> accountRelationships;

  /**
   * A categorization of an account, such as individual, joint, and so forth,
   * whose instances share some of the same characteristics. Note: for flexibility
   * we use a String here but an implementation may use an enumeration with a
   * limited list of valid values.
   */
  private @SafeText String accountType;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money creditLimit;

  /**
   * Detailed description of the party account.
   */
  private @SafeText String description;

  /**
   * Date of last modification of the account.
   */
  private OffsetDateTime lastModified;

  /**
   * Contains the lifecycle state such as: Active, Closed, Suspended and so on.
   */
  private @SafeText String state;
}