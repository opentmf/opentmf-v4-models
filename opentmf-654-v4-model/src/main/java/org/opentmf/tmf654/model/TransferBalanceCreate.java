package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The TransferBalance resource is a detailed description of credit transfer
 * operation requested between two buckets (reference to products owned by
 * customers and consuming credit when using a service).
 * <br/>Skipped properties:
 * id,href,status,requestedDate,confirmationDate,relatedParty,partyAccount.
 *
 * <p><br/>
 * <strong>Required:</strong> amount, bucket, channel, logicalResource, reason, receiverBucket, receiverBucketUsageType, receiverLogicalResource, usageType<br/>
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
    defaultImpl = TransferBalanceCreate.class
)
@Required(fields = {"bucket", "receiverBucket", "reason", "amount", "receiverBucketUsageType", "receiverLogicalResource", "channel", "logicalResource", "usageType"})
public class TransferBalanceCreate extends TransferBalanceUpdate implements ITransferBalanceCreate {

  /**
   * Description of the recharge operation.
   */
  private @SafeText String description;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}