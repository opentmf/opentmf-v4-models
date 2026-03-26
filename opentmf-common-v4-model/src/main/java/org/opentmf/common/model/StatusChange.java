package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Holds the status notification reasons and associated date the status changed,
 * populated by the server.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-621: Trouble Ticket Management API</li>
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
    defaultImpl = StatusChange.class
)
public class StatusChange extends Entity implements IStatusChange {

  /**
   * The date and time the status changed.
   */
  private OffsetDateTime changeDate;

  /**
   * The reason why the status changed.
   */
  private @SafeText String changeReason;

  /**
   * The status of the trouble ticket.
   */
  private @SafeText String status;
}