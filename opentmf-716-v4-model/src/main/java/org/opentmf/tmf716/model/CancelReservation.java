package org.opentmf.tmf716.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A Cancel Reservation is a type of task which can be used to place a request
 * to cancel a reservation.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-716: ResourceReservation</li>
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
    defaultImpl = CancelReservation.class
)
public class CancelReservation extends Entity implements ICancelReservation {

  /**
   * Reason why the reservation is cancelled.
   */
  private @SafeText String cancellationReason;

  /**
   * Date when the reservation is cancelled.
   */
  private @SafeText String effectiveCancellationDate;

  /**
   * Date when the submitter wants the reservation to be cancelled.
   */
  private @SafeText String requestedCancellationDate;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}