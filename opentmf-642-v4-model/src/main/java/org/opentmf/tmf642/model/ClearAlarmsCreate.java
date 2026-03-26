package org.opentmf.tmf642.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Alarm;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Task resource for clear alarms operation
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> alarmClearedTime, alarmPattern, clearSystemId, clearUserId<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-642: Alarm Management API</li>
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
    defaultImpl = ClearAlarmsCreate.class
)
@Required(fields = {"alarmClearedTime", "alarmPattern", "clearUserId", "clearSystemId"})
public class ClearAlarmsCreate extends Extensible implements IClearAlarmsCreate {

  /**
   * Time of the alarm clearing.
   */
  private OffsetDateTime alarmClearedTime;

  /**
   * Alarm patterns to match target alarms. An alarm will match if all of the
   * sttributes in any of the patterns compare equal to those attributes of the
   * alarm.
   */
  @JsonProperty("alarmPattern")
  private @Size(min = 1) List<@Valid Alarm> alarmPatterns;

  /**
   * Name of the clearing system.
   */
  @SafeId
  @Size(max = 100)
  private String clearSystemId;

  /**
   * Name of the clearing user.
   */
  @SafeId
  @Size(max = 100)
  private String clearUserId;

  /**
   * The successfully cleared alarms.
   */
  @JsonProperty("clearedAlarm")
  private List<@Valid AlarmRefOrValue> clearedAlarms;

  /**
   * Current state of the operation task.
   */
  private @SafeText String state;
}