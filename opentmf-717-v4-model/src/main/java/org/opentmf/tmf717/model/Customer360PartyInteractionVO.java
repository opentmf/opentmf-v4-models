package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.InteractionItem;
import org.opentmf.common.model.InteractionRelationship;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.RelatedChannel;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
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
    defaultImpl = Customer360PartyInteractionVO.class
)
public class Customer360PartyInteractionVO extends Entity implements ICustomer360PartyInteractionVO {

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Where the interaction took place (e.g. web, mobile app, store, kiosk, etc.).
   */
  @JsonProperty("channel")
  private List<@Valid RelatedChannel> channels;

  /**
   * Date when the interaction is created in the system.
   */
  private OffsetDateTime creationDate;

  /**
   * Description of the interaction.
   */
  private @SafeText String description;

  /**
   * Specifies who started the interaction. It might be the party or the
   * enterprise exposing this API. Possible values are “inbound” and “outbound”.
   */
  private @SafeText String direction;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod interactionDate;

  @JsonProperty("interactionItem")
  private List<@Valid InteractionItem> interactionItems;

  @JsonProperty("interactionRelationship")
  private List<@Valid InteractionRelationship> interactionRelationships;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Reason why the interaction happened.
   */
  private @SafeText String reason;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Status of the interaction (opened, inProgress, completed).
   */
  private @SafeText String status;

  /**
   * Last time the status changed.
   */
  private OffsetDateTime statusChangeDate;
}