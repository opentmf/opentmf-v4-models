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
 * Task resource for unacknowledge alarms operation
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> ackSystemId, ackUserId, alarmPattern<br/>
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
    defaultImpl = UnAckAlarmsCreate.class
)
@Required(fields = {"ackUserId", "alarmPattern", "ackSystemId"})
public class UnAckAlarmsCreate extends Extensible implements IUnAckAlarmsCreate {

  /**
   * Name of the unacknowledging system.
   */
  @SafeId
  @Size(max = 100)
  private String ackSystemId;

  /**
   * Time of the unacknowledgement.
   */
  private OffsetDateTime ackTime;

  /**
   * Name of the unacknowledging user.
   */
  @SafeId
  @Size(max = 100)
  private String ackUserId;

  /**
   * Alarm patterns to match target alarms. An alarm will match if all of the
   * sttributes in any of the patterns compare equal to those attributes of the
   * alarm.
   */
  @JsonProperty("alarmPattern")
  private @Size(min = 1) List<@Valid Alarm> alarmPatterns;

  /**
   * Current state of the operation task.
   */
  private @SafeText String state;

  /**
   * The successfully unacknowledged alarms.
   */
  @JsonProperty("unAckedAlarm")
  private List<@Valid AlarmRefOrValue> unAckedAlarms;
}