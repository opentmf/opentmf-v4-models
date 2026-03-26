package org.opentmf.tmf642.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Alarm;
import org.opentmf.common.model.Comment;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Task resource for comment alarms operation
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> alarmPattern, comment<br/>
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
    defaultImpl = CommentAlarmsCreate.class
)
@Required(fields = {"alarmPattern", "comment"})
public class CommentAlarmsCreate extends Extensible implements ICommentAlarmsCreate {

  /**
   * Alarm patterns to match target alarms. An alarm will match if all of the
   * sttributes in any of the patterns compare equal to those attributes of the
   * alarm.
   */
  @JsonProperty("alarmPattern")
  private @Size(min = 1) List<@Valid Alarm> alarmPatterns;

  /**
   * Indicates the comments entered on the alarm.
   */
  private @Valid Comment comment;

  /**
   * The successfully commented alarms.
   */
  @JsonProperty("commentedAlarm")
  private List<@Valid AlarmRefOrValue> commentedAlarms;

  /**
   * Current state of the operation task.
   */
  private @SafeText String state;
}