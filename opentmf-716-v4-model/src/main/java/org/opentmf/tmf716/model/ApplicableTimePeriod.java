package org.opentmf.tmf716.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The period of time for which Capacity or CapacityDemand applies.
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
    defaultImpl = ApplicableTimePeriod.class
)
public class ApplicableTimePeriod extends Extensible implements IApplicableTimePeriod {

  /**
   * A day or days representing when the schedule is applicable. For example 2, 3
   * represent Monday and Tuesday.
   */
  private @SafeText String dayOfWeek;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod fromToDateTime;

  /**
   * An indicator that specifies the inclusion or exclusion of the from and to
   * DateTime attributes. 
   * <br/>Possible values are "open", "closed", "closedBottom" and "closedTop".
   */
  private @SafeText String rangeInterval;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}