package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.PartyAccountRef;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The TransferBalance resource is a detailed description of credit transfer
 * operation requested between two buckets (reference to products owned by
 * customers and consuming credit when using a service).
 *
 * <p><br/>
 * <strong>Required:</strong> channel, href, id, logicalResource, reason, receiverLogicalResource, status<br/>
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
    defaultImpl = TransferBalance.class
)
@Required(fields = {"reason", "receiverLogicalResource", "channel", "href", "id", "logicalResource", "status"})
public class TransferBalance extends TransferBalanceCreate implements ITransferBalance {

  /**
   * Date when the deduction was confirmed in the server.
   */
  private OffsetDateTime confirmationDate;

  /**
   * A reference to the resource.
   */
  private URI href;

  /**
   * Unique Identifier for the resource.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * PartyAccount reference. A party account is an arrangement that a party has
   * with an enterprise that provides products to the party.
   */
  private @Valid PartyAccountRef partyAccount;

  /**
   * Used to provide information about any other entity with relation to the
   * operation.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Date when the deduction request was received in the server.
   */
  private OffsetDateTime requestedDate;

  /**
   * Valid values for the Action Status Type
   * <br/><p>Recommended values: created, failed, cancelled, completed.
   *
   * @see org.opentmf.tmf654.model.ActionStatusType
   */
  private @SafeText String status;
}