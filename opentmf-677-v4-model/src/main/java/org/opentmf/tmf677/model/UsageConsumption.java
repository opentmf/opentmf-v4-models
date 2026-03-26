package org.opentmf.tmf677.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.PartyAccountRef;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An usage consumption enables to know at a given point the balances and the
 * consumption counters related to various buckets (SMS, Voice, Data for
 * example). It could be calculated for a device identified by a public key
 * (msisdn number for a mobile device for example or PSTN or VOIP number for a
 * fix device), for a subscribed offer or option or for an user.
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
    defaultImpl = UsageConsumption.class
)
public class UsageConsumption extends NamedEntity implements IUsageConsumption {

  /**
   * Bucket(s) included in the offer or option subscribed.
   */
  @JsonProperty("bucketRefOrValue")
  private List<@Valid BucketRefOrValue> bucketRefOrValues;

  /**
   * Date and time of the request creation.
   */
  private OffsetDateTime creationDate;

  /**
   * Free short text describing the usage consumption content.
   */
  private @SafeText String description;

  /**
   * Date when the status was last changed.
   */
  private OffsetDateTime lastUpdate;

  /**
   * List of: reference to the LogicalResource eg MSISDN.
   */
  @JsonProperty("logicalResource")
  private List<@Valid UsageConsumptionLogicalResourceRef> logicalResources;

  /**
   * A reference to the account that owns the bucket.
   */
  @JsonProperty("partyAccount")
  private List<@Valid PartyAccountRef> partyAccounts;

  @JsonProperty("product")
  private List<@Valid UsageConsumptionProductRef> products;

  /**
   * Reference and role of the related parties for which the usage consumption is
   * requested.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * List of: Service reference, for when Service is used by other entities.
   */
  @JsonProperty("service")
  private List<@Valid UsageConsumptionServiceRef> services;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validPeriod;
}