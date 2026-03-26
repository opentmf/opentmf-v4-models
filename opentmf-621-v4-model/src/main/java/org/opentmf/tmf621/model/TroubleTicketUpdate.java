package org.opentmf.tmf621.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.RelatedEntity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A trouble ticket is a record of an issue that is created, tracked, and
 * managed by a trouble ticket management system
 * <br/>Skipped properties:
 * id,href,creationDate,lastUpdate,statusChange,statusChangeDate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-621: Trouble Ticket Management API</li>
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
    defaultImpl = TroubleTicketUpdate.class
)
public class TroubleTicketUpdate extends Extensible implements ITroubleTicketUpdate {

  /**
   * File(s) attached to the trouble ticket. e.g. pictur of broken device, scaning
   * of a bill or charge.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * The channel to which the resource reference to. e.g. channel for selling
   * product offerings, channel for opening a trouble ticket etc..
   */
  private @Valid ChannelRef channel;

  /**
   * Description of the trouble or issue.
   */
  private @SafeText String description;

  /**
   * The expected resolution date determined by the trouble ticket system.
   */
  private OffsetDateTime expectedResolutionDate;

  /**
   * Additional identifier coming from an external system.
   */
  @SafeId
  @Size(max = 100)
  private String externalId;

  /**
   * Name of the trouble ticket, typically a short description provided by the
   * user that create the ticket.
   */
  private @SafeText String name;

  /**
   * The note(s) that are associated to the ticket.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * The priority of the trouble ticket and how quickly the issue should be
   * resolved. Example: Critical, High, Medium, Low. The value is set by the
   * ticket management system considering the severity, ticket type etc...
   */
  private @SafeText String priority;

  /**
   * An entity that is related to the ticket such as a bill, a product, etc. The
   * entity against which the ticket is associated.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntity> relatedEntities;

  /**
   * The related party(ies) that are associated to the ticket.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * The resolution date requested by the user.
   */
  private OffsetDateTime requestedResolutionDate;

  /**
   * The date and time the trouble ticket was resolved.
   */
  private OffsetDateTime resolutionDate;

  /**
   * The severity of the issue. Indicate the implication of the issue on the
   * expected functionality e.g. of a system, application, service etc.. 
   * <br/>Severity values can be for example : Critical, Major, Minor.
   */
  private @SafeText String severity;

  /**
   * Possible values for the status of the trouble ticket
   * <br/><p>Recommended values: acknowledged, rejected, pending, held,
   * inProgress, cancelled, closed, resolved.
   *
   * @see org.opentmf.common.model.TroubleTicketStatusType
   */
  private @SafeText String status;

  /**
   * The reason for changing the status.
   */
  private @SafeText String statusChangeReason;

  /**
   * represent a business type of the trouble ticket e.g. incident, complain,
   * request.
   */
  private @SafeText String ticketType;

  /**
   * A list of trouble ticket relationships (TroubleTicketRelationship [*]).
   * Represents a relationship between trouble tickets.
   */
  @JsonProperty("troubleTicketRelationship")
  private List<@Valid TroubleTicketRelationship> troubleTicketRelationships;
}