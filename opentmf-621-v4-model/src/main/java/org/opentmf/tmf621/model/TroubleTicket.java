package org.opentmf.tmf621.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A trouble ticket is a record of an issue that is created, tracked, and
 * managed by a trouble ticket management system.
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
    defaultImpl = TroubleTicket.class
)
public class TroubleTicket extends TroubleTicketCreate implements ITroubleTicket {

  /**
   * Hyperlink, a reference to the trouble ticket entity.
   */
  private URI href;

  /**
   * Unique identifier of the trouble ticket.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}