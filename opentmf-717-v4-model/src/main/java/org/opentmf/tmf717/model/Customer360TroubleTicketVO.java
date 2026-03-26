package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.StatusChange;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A trouble ticket is a record of an issue that is created, tracked, and
 * managed by a trouble ticket management system.
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
    defaultImpl = Customer360TroubleTicketVO.class
)
public class Customer360TroubleTicketVO extends NamedEntity implements ICustomer360TroubleTicketVO {

  /**
   * The channel to which the resource reference to. e.g. channel for selling
   * product offerings, channel for opening a trouble ticket etc..
   */
  private @Valid ChannelRef channel;

  /**
   * The date on which the trouble ticket was created.
   */
  private OffsetDateTime creationDate;

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
   * The date and time that the trouble ticked was last updated.
   */
  private OffsetDateTime lastUpdate;

  /**
   * The priority of the trouble ticket and how quickly the issue should be
   * resolved. Example: Critical, High, Medium, Low. The value is set by the
   * ticket management system considering the severity, ticket type etc...
   */
  private @SafeText String priority;

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
   * The status change history that are associated to the ticket.Populated by the
   * server.
   */
  @JsonProperty("statusChange")
  private List<@Valid StatusChange> statusChanges;

  /**
   * The date and time the status changed.
   */
  private OffsetDateTime statusChangeDate;

  /**
   * The reason for changing the status.
   */
  private @SafeText String statusChangeReason;

  /**
   * represent a business type of the trouble ticket e.g. incident, complain,
   * request.
   */
  private @SafeText String ticketType;
}