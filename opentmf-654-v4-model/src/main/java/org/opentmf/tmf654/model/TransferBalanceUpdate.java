package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.Money;
import org.opentmf.common.model.ProductRef;
import org.opentmf.common.model.Quantity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The TransferBalance resource is a detailed description of credit transfer
 * operation requested between two buckets (reference to products owned by
 * customers and consuming credit when using a service).
 * <br/>Skipped properties:
 * id,href,status,requestedDate,confirmationDate,validFor,description,partyAccount,relatedParty.
 *
 * <p><br/>
 * <strong>Required:</strong> channel, logicalResource, reason, receiverLogicalResource<br/>
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
    defaultImpl = TransferBalanceUpdate.class
)
@Required(fields = {"reason", "receiverLogicalResource", "channel", "logicalResource"})
public class TransferBalanceUpdate extends Extensible implements ITransferBalanceUpdate {

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
   * Valid values for this type
   * <br/><p>Recommended values: originator, receiver.
   *
   * @see org.opentmf.tmf654.model.CostOwnerType
   */
  private @SafeText String costOwner;

  /**
   * List of: reference to the LogicalResource eg MSISDN.
   */
  @JsonProperty("logicalResource")
  private @Size(min = 1) List<@Valid LogicalResourceRef> logicalResources;

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
  private @Valid RelatedParty receiver;

  /**
   * link to the resource that holds bucket information.
   */
  private @Valid BucketRef receiverBucket;

  /**
   * Valid values for the usage type are
   * <br/><p>Recommended values: monetary, voice, data, sms, other.
   *
   * @see org.opentmf.tmf654.model.UsageType
   */
  private @SafeText String receiverBucketUsageType;

  /**
   * reference to the LogicalResource eg MSISDN.
   */
  private @Valid LogicalResourceRef receiverLogicalResource;

  private @Valid ProductRef receiverProduct;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  @JsonProperty("requestor")
  private @Valid RelatedParty requester;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money transferCost;

  /**
   * Valid values for the usage type are
   * <br/><p>Recommended values: monetary, voice, data, sms, other.
   *
   * @see org.opentmf.tmf654.model.UsageType
   */
  private @SafeText String usageType;
}