package org.opentmf.tmf646.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.TimeSlot;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This task resource is used to retrieve available time slots. One of this
 * available time slot is after used to create or reschedule an appointment
 * <br/>Skipped properties: id,href,searchDate,searchResult.
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
    defaultImpl = SearchTimeSlotUpdate.class
)
public class SearchTimeSlotUpdate extends SearchTimeSlotCreate implements ISearchTimeSlotUpdate {

  @JsonProperty("availableTimeSlot")
  private List<@Valid TimeSlot> availableTimeSlots;

  /**
   * Valid values for the lifecycle state of the searchTimeSlot
   * <br/><p>Recommended values: inProgress, done, rejected, terminatedWithError.
   *
   * @see org.opentmf.tmf646.model.SearchTimeSlotStateType
   */
  private @SafeText String status;
}