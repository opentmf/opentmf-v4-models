package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.PartyAccountRef;
import org.opentmf.common.model.ProductRef;
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
    defaultImpl = Bucket.class
)
public class Bucket extends NamedEntity implements IBucket {

  /**
   * Date when the deduction was confirmed in the server.
   */
  private OffsetDateTime confirmationDate;

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
  private List<@Valid LogicalResourceRef> logicalResources;

  /**
   * PartyAccount reference. A party account is an arrangement that a party has
   * with an enterprise that provides products to the party.
   */
  private @Valid PartyAccountRef partyAccount;

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
  private @Valid Quantity remainingValue;

  /**
   * Remaining amount in a formatted string for the bucket given in the balance
   * unit (for example 1.9 Gb). This formatted string could be used for display
   * needs for example.
   */
  private @SafeText String remainingValueName;

  /**
   * Date when the deduction request was received in the server.
   */
  private OffsetDateTime requestedDate;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity reservedValue;

  /**
   * Valid values for the Balance Status Type
   * <br/><p>Recommended values: active, suspended, expired.
   *
   * @see org.opentmf.tmf654.model.BucketStatusType
   */
  private @SafeText String status;

  /**
   * Valid values for the usage type are
   * <br/><p>Recommended values: monetary, voice, data, sms, other.
   *
   * @see org.opentmf.tmf654.model.UsageType
   */
  private @SafeText String usageType;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}