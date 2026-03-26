package org.opentmf.tmf677.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.PartyAccountRef;
import org.opentmf.common.model.Quantity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A bucket (called UsageVolumProduct in the SID Model) represents and tracks a
 * quantity of usage (remaining or consumed). It could be either a quantity or
 * an amount in a currency. It can represent a fixed number of SMS,MMS, call
 * minutes, quantity of data and so on.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = BucketRefOrValue.class
)
public class BucketRefOrValue extends NamedEntity implements IBucketRefOrValue {

  /**
   * List of: The consumption counters (called ConsumptionSummary in the SID
   * model) detail for example the different kind of consumption done on the
   * bucket.
   */
  @JsonProperty("bucketCounter")
  private List<@Valid ConsumptionSummary> bucketCounters;

  /**
   * List of: Linked bucket to the one instantiate, such as [isAggregated] if the
   * bucket is a part of other or [aggregator] is the bucket holds others.
   */
  @JsonProperty("bucketRelationship")
  private List<@Valid BucketRelationship> bucketRelationships;

  /**
   * Text describing the contents of the balance managed by the bucket.
   */
  private @SafeText String description;

  /**
   * True if the bucket is shared between several devices or users.
   */
  private Boolean isShared;

  /**
   * List of: reference to the LogicalResource eg MSISDN.
   */
  @JsonProperty("logicalResource")
  private List<@Valid UsageConsumptionLogicalResourceRef> logicalResources;

  /**
   * PartyAccount reference. A party account is an arrangement that a party has
   * with an enterprise that provides products to the party.
   */
  private @Valid PartyAccountRef partyAccount;

  @JsonProperty("product")
  private List<@Valid UsageConsumptionProductRef> products;

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
  private @Valid Quantity remainingValue;

  /**
   * Remaining amount in a formatted string for the bucket given in the balance
   * unit (for example 1.9 Gb). This formatted string could be used for display
   * needs for example.
   */
  private @SafeText String remainingValueName;

  /**
   * List of: The ReserveBalance resource allows adjustments to be made to the
   * original BalanceTopup eg increment the amount, alter the recharge
   * periodicity.
   */
  @JsonProperty("reserveBalance")
  private List<@Valid ReserveBalanceRef> reserveBalances;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity reservedValue;

  /**
   * List of: Service reference, for when Service is used by other entities.
   */
  @JsonProperty("service")
  private List<@Valid UsageConsumptionServiceRef> services;

  /**
   * status for the bucket. active, expired, suspended.
   */
  private @SafeText String status;

  /**
   * defines the type of the underlying Balance eg data,voice, any currency eg
   * EUR, USD etc.
   */
  private @SafeText String usageType;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}