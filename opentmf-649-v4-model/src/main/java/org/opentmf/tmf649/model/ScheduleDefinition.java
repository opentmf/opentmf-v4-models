package org.opentmf.tmf649.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The schedule definition for running jobs.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-649: Performance Thresholding Management API</li>
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
    defaultImpl = ScheduleDefinition.class
)
public class ScheduleDefinition extends Extensible implements IScheduleDefinition {

  @JsonProperty("MonthlyScheduleDayOfWeekDefinition")
  private @Valid MonthlyScheduleDayOfWeekDefinition monthlyScheduleDayOfWeekDefinition;

  /**
   * The weekly schedule is used to define a schedule that is based on the days of
   * the week, e.g. a schedule that will be active only on Monday and Tuesday.
   */
  @JsonProperty("WeeklyScheduledDefinition")
  private List<@Valid DayOfWeekRecurrence> weeklyScheduledDefinitions;

  /**
   * A recurring frequency to run a job within day that is included in schedule
   * definition, for example: every 5 minutes, 15 minute, 30 minutes, 1 hour.
   */
  private @SafeText String recurringFrequency;

  /**
   * The Endtime of the Schedule Definition. If the attribute is empty the
   * Schedule run forever, not having a time constraint.
   */
  private OffsetDateTime scheduleDefinitionEndTime;

  /**
   * A list of time ranges within a specific day that the schedule will be active
   * on, for example 08:00-12:00, 16:00-19:00.
   */
  private @SafeText String scheduleDefinitionHourRange;

  /**
   * The Start time of the Schedule Definition.
   */
  private OffsetDateTime scheduleDefinitionStartTime;
}