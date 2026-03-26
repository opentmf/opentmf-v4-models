package org.opentmf.tmf646.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This task resource is used to retrieve available time slots. One of this
 * available time slot is after used to create or reschedule an appointment.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-646: Appointment Management API</li>
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
    defaultImpl = SearchTimeSlot.class
)
public class SearchTimeSlot extends SearchTimeSlotUpdate implements ISearchTimeSlot {

  /**
   * Reference to access the search time slot resource.
   */
  private URI href;

  /**
   * Unique identifier of the search time slot request.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Date when the search time slot is performed.
   */
  private OffsetDateTime searchDate;

  /**
   * Result of the search time slot (success or fail for example).
   */
  private @SafeText String searchResult;
}