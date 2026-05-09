package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CalendarEventRef;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

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
    defaultImpl = Customer360AppointmentVO.class
)
@Required(fields = {"validFor"})
public class Customer360AppointmentVO extends Entity implements ICustomer360AppointmentVO {

  /**
   * Reference of a CalendarEvent.
   */
  private @Valid CalendarEventRef calendarEvent;

  /**
   * Business category : intervention for example or to be more precise after
   * SalesIntervention, orderDeliveryIntervention,...
   */
  private @SafeText String category;

  /**
   * Appointment creation date.
   */
  private OffsetDateTime creationDate;

  /**
   * Short free text describing the appointment.
   */
  private @SafeText String description;

  /**
   * External reference known by the customer.
   */
  @SafeId
  @Size(max = 100)
  private String externalId;

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

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}