package org.opentmf.tmf642.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Task resource for group alarms operation
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> alarmChangedTime, correlatedAlarm, parentAlarm, sourceSystemId<br/>
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
    defaultImpl = GroupAlarmsCreate.class
)
@Required(fields = {"sourceSystemId", "correlatedAlarm", "alarmChangedTime", "parentAlarm"})
public class GroupAlarmsCreate extends Extensible implements IGroupAlarmsCreate {

  /**
   * Time of the correlation.
   */
  private OffsetDateTime alarmChangedTime;

  /**
   * Correlated alarms.
   */
  @JsonProperty("correlatedAlarm")
  private @Size(min = 1) List<@Valid AlarmRefOrValue> correlatedAlarms;

  /**
   * The successfully correlated alarms.
   */
  @JsonProperty("groupedAlarm")
  private List<@Valid AlarmRefOrValue> groupedAlarms;

  /**
   * An alarm defined by reference or value. The polymorphic attributes {@literal @}type,
   * {@literal @}schemaLocation & {@literal @}referredType are related to the alarm entity and not the
   * RelatedAlarmRefOrValue class itself.
   */
  private @Valid AlarmRefOrValue parentAlarm;

  /**
   * Source system identifier.
   */
  @SafeId
  @Size(max = 100)
  private String sourceSystemId;

  /**
   * Current state of the operation task.
   */
  private @SafeText String state;
}