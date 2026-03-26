package org.opentmf.tmf646.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * An Appointment is an arrangement to do something or meet someone at a
 * particular time, at a place (for face to face appointment) or in a contact
 * medium (for phone appointment).
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
    defaultImpl = Appointment.class
)
@Required(fields = {"validFor"})
public class Appointment extends AppointmentUpdate implements IAppointment {

  /**
   * Appointment creation date.
   */
  private OffsetDateTime creationDate;

  /**
   * Unique URI used to access to the appointment resource.
   */
  private URI href;

  /**
   * Unique identifier of the appointment.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}