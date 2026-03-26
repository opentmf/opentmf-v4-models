package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This resource represents an alarm supporting the information model defined in
 * ITU-T X.733.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> alarmRaisedTime, alarmType, alarmedObject, perceivedSeverity, probableCause, sourceSystemId, state<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-642: Alarm Management API</li>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
 *   <li>TMF-915: AI Management API</li>
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
    defaultImpl = AlarmCreate.class
)
@Required(fields = {"alarmRaisedTime", "alarmType", "perceivedSeverity", "probableCause", "sourceSystemId", "state", "alarmedObject"})
public class AlarmCreate extends Extensible implements IAlarmCreate {

  /**
   * Provides the Acknowledgement State of the alarm.
   */
  private @SafeText String ackState;

  /**
   * Provides the name of the system that last changed the ackState of an alarm,
   * i.e. acknowledged or unacknowledged the alarm.
   */
  @SafeId
  @Size(max = 100)
  private String ackSystemId;

  /**
   * Provides the id of the user who has last changed the ack state of the alarm,
   * i.e. acknowledged or unacknowledged the alarm.
   */
  @SafeId
  @Size(max = 100)
  private String ackUserId;

  @JsonProperty("affectedService")
  private List<@Valid AffectedService> affectedServices;

  /**
   * Indicates the last date and time when the alarm is changed on the
   * alarm-owning system. Any change to the alarm whether coming from the alarmed
   * resource, or triggered by a change from the client is changing this time.
   */
  private OffsetDateTime alarmChangedTime;

  /**
   * Indicates the time (as a date + time) at which the alarm is cleared at the
   * source.
   */
  private OffsetDateTime alarmClearedTime;

  /**
   * Contains further information on the alarm.
   */
  private @SafeText String alarmDetails;

  /**
   * Indicates if this alarm has been escalated or not.
   */
  private Boolean alarmEscalation;

  /**
   * Indicates the time (as a date + time) at which the alarm occurred at its
   * source.
   */
  private OffsetDateTime alarmRaisedTime;

  /**
   * Indicates the time (as a date + time) at which the alarm was reported by the
   * owning OSS. It might be different from the alarmRaisedTime. For instance, if
   * the alarm list is maintained by an EMS, the alarmRaisedtime would be the time
   * the alarm
   * <br/> was detected by the NE, while the alarmReportingTime would be the time
   * this alarm was stored in the alarm list of the EMS.
   */
  private OffsetDateTime alarmReportingTime;

  /**
   * Categorize the alarm. Should be one of the values defined in X.733 8.1.1 or
   * 3GPP TS 32.111-2 Annex A:
   * <br/>	Communications Alarm
   * <br/>	Processing Error Alarm
   * <br/>	Environmental Alarm
   * <br/>	Quality of Service Alarm
   * <br/>	Equipment Alarm
   * <br/>	Integrity Violation
   * <br/>	Operational Violation
   * <br/>	Physical Violation
   * <br/>	Security Service or Mechanism Violation
   * <br/>	Time Domain Violation.
   */
  private @SafeText String alarmType;

  /**
   * Identifies the managed object instance associated with the alarm.
   */
  private @Valid AlarmedObject alarmedObject;

  /**
   * The type (class) of the managed object associated with the event.
   */
  private @SafeText String alarmedObjectType;

  /**
   * Provides the id of the system where the user who invoked the alarmCleared
   * operation is located.
   */
  @SafeId
  @Size(max = 100)
  private String clearSystemId;

  /**
   * Provides the id of the user who invoked the alarmCleared operation.
   */
  @SafeId
  @Size(max = 100)
  private String clearUserId;

  /**
   * List of: Indicates the comments entered on the alarm.
   */
  @JsonProperty("comment")
  private List<@Valid Comment> comments;

  @JsonProperty("correlatedAlarm")
  private List<@Valid AlarmRef> correlatedAlarms;

  /**
   * Identifies the details of the threshold that has been crossed.
   */
  private @Valid CrossedThresholdInformation crossedThresholdInformation;

  /**
   * An identifier of the alarm in the source system.
   */
  @SafeId
  @Size(max = 100)
  private String externalAlarmId;

  /**
   * Indicates whether the alarm is a root cause alarm..
   */
  private Boolean isRootCause;

  @JsonProperty("parentAlarm")
  private List<@Valid AlarmRef> parentAlarms;

  /**
   * Lists the possible severities that can be allocated to an Alarm. The values
   * are consistent with ITU-T Recommendation X.733.
   * <br/>Once an alarm has been cleared, its perceived severity is set to
   * 'cleared' and can no longer be set.
   */
  private @SafeText String perceivedSeverity;

  /**
   * List of: Related Entity reference. A related place defines a place described
   * by reference or by value linked to a specific entity. The polymorphic
   * attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place
   * entity and not the RelatedPlaceRefOrValue class itself.
   */
  @JsonProperty("place")
  private List<@Valid RelatedPlaceRefOrValue> places;

  /**
   * Indicates that the Managed Object (related to this alarm) is in planned
   * outage (in planned maintenance, or out-of-service).
   */
  private @SafeText String plannedOutageIndicator;

  /**
   * Provides the probable cause of the alarm. The values are consistent with
   * ITU-T Recommendation X.733 or 3GPP TS 32.111-2 Annex B.
   */
  private @SafeText String probableCause;

  /**
   * Indicates proposed repair actions, if known to the system emitting the alarm.
   */
  private @SafeText String proposedRepairedActions;

  /**
   * Reporting system identity.
   */
  @SafeId
  @Size(max = 100)
  private String reportingSystemId;

  /**
   * Indicates whether the alarm affects service or not.
   */
  private Boolean serviceAffecting;

  /**
   * Source system identity.
   */
  @SafeId
  @Size(max = 100)
  private String sourceSystemId;

  /**
   * Provides more specific information about the alarm.
   */
  private @SafeText String specificProblem;

  /**
   * Defines the alarm state during its life cycle.
   */
  private @SafeText String state;
}