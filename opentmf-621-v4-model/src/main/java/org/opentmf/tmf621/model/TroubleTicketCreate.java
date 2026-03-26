package org.opentmf.tmf621.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.StatusChange;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A trouble ticket is a record of an issue that is created, tracked, and
 * managed by a trouble ticket management system
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> description, severity, ticketType<br/>
 * </p>
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
    defaultImpl = TroubleTicketCreate.class
)
@Required(fields = {"severity", "description", "ticketType"})
public class TroubleTicketCreate extends TroubleTicketUpdate implements ITroubleTicketCreate {

  /**
   * The date on which the trouble ticket was created.
   */
  private OffsetDateTime creationDate;

  /**
   * The date and time that the trouble ticked was last updated.
   */
  private OffsetDateTime lastUpdate;

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
}