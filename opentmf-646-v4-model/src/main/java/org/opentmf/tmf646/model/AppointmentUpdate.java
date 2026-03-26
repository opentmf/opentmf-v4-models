package org.opentmf.tmf646.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An Appointment is an arrangement to do something or meet someone at a
 * particular time, at a place (for face to face appointment) or in a contact
 * medium (for phone appointment).
 * <br/>Skipped properties: id,href,creationDate.
 *
 * <p><br/>
 * <strong>Required:</strong> validFor<br/>
 * </p>
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
    defaultImpl = AppointmentUpdate.class
)
@Required(fields = {"validFor"})
public class AppointmentUpdate extends AppointmentCreate implements IAppointmentUpdate {

  /**
   * Date of last appointment update.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Valid values for the lifecycle state of the appointment
   * <br/><p>Recommended values: initialized, confirmed, cancelled, completed,
   * failed.
   *
   * @see org.opentmf.customer.model.AppointmentStateType
   */
  private @SafeText String status;
}