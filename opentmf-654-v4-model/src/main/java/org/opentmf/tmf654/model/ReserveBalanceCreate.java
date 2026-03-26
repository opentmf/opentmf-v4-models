package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.PartyAccountRef;
import org.opentmf.common.model.ProductRef;
import org.opentmf.common.model.Quantity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The ReserveBalance resource allows adjustments to be made to the original
 * BalanceTopup eg increment the amount, alter the recharge periodicity
 * <br/>Skipped properties:
 * id,href,status,requestedDate,confirmationDate,relatedParty.
 *
 * <p><br/>
 * <strong>Required:</strong> bucket, partyAccount, usageType<br/>
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
    defaultImpl = ReserveBalanceCreate.class
)
@Required(fields = {"bucket", "partyAccount", "usageType"})
public class ReserveBalanceCreate extends Extensible implements IReserveBalanceCreate {

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity amount;

  /**
   * link to the resource that holds bucket information.
   */
  private @Valid BucketRef bucket;

  /**
   * The channel to which the resource reference to. e.g. channel for selling
   * product offerings, channel for opening a trouble ticket etc..
   */
  private @Valid ChannelRef channel;

  /**
   * Description of the recharge operation.
   */
  private @SafeText String description;

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
   * Text describing the reason for the action/task.
   */
  private @SafeText String reason;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  @JsonProperty("requestor")
  private @Valid RelatedParty requester;

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