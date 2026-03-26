package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.PartyAccountRef;
import org.opentmf.common.model.ProductRef;
import org.opentmf.common.model.Quantity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Represents and tracks the aggregated amount remained or owed in certain
 * account which is owned by certain customer for a set of buckets.
 *
 * <p><br/>
 * <strong>Required:</strong> bucket, name, totalBalance<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-654: Prepay Balance Management API</li>
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
    defaultImpl = AccumulatedBalance.class
)
@Required(fields = {"bucket", "totalBalance", "name"})
public class AccumulatedBalance extends NamedEntity implements IAccumulatedBalance {

  /**
   * A reference to the buckets involved in the aggregation.
   */
  @JsonProperty("bucket")
  private @Size(min = 1) List<@Valid BucketRef> buckets;

  /**
   * Text describing the contents of the aggregated balance.
   */
  private @SafeText String description;

  /**
   * reference to the LogicalResource eg MSISDN.
   */
  private @Valid LogicalResourceRef logicalResource;

  /**
   * PartyAccount reference. A party account is an arrangement that a party has
   * with an enterprise that provides products to the party.
   */
  private @Valid PartyAccountRef partyAccount;

  /**
   * A reference to the product whose consumption is managed by the bucket . This
   * is an array to allow scenarios where a buckets are shared between different
   * products.
   */
  @JsonProperty("product")
  private List<@Valid ProductRef> products;

  /**
   * Used to provide information about any other entity with relation to the
   * balance, for instance to define customer hierarchy for the balance (e.g.:
   * customerId, userId, ).
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity totalBalance;
}