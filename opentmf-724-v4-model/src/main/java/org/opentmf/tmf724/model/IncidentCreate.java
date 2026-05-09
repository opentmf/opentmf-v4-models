package org.opentmf.tmf724.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.EntityRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ExternalIdentifier;
import org.opentmf.common.model.ResourceEntity;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An Incident is a record of an event that has altered the operational state of
 * a entity (Resource, Service or Customers Product). An incident represents an
 * issue that needs to be diagnosed and resolved.
 * <br/>Skipped properties:
 * id,href,lifecycleStatus,creationDate,statusChangeDate.
 *
 * <p><br/>
 * <strong>Required:</strong> ackState, category, domain, name, occurTime, priority, sourceObject, state<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-724: Incident Management API</li>
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
    defaultImpl = IncidentCreate.class
)
@Required(fields = {"ackState", "domain", "occurTime", "name", "sourceObject", "state", "category", "priority"})
public class IncidentCreate extends Extensible implements IIncidentCreate {

  /**
   * Possible values for the ack state of an Incident
   * <br/><p>Recommended values: acknowledged, unacknowledged.
   *
   * @see org.opentmf.tmf724.model.IncidentAckStateType
   */
  private @SafeText String ackState;

  /**
   * The ackTime or acknowledgeTime of the incident. An acknowledged incident is
   * being worked on, but is not yet resolved.
   */
  private OffsetDateTime ackTime;

  /**
   * List of affected entities.
   */
  @JsonProperty("affectedEntity")
  private List<@Valid EntityRef> affectedEntities;

  /**
   * The category of the incident (category is the term used by ITU).
   */
  private @SafeText String category;

  /**
   * The clear time of the incident.
   */
  private OffsetDateTime clearTime;

  /**
   * The domain of the incident, for example RAN, PON, OTN, Cross-Domain etc.
   */
  private @SafeText String domain;

  /**
   * The correlation event object such as alarm, externalAlarm, performance, etc.
   */
  @JsonProperty("eventId")
  private List<@Valid ResourceEntity> eventIds;

  /**
   * This is used for extend the incident with attributes.
   */
  @JsonProperty("extensionInfo")
  private List<@Valid Characteristic> extensionInfoes;

  /**
   * An identification of an entity that is owned by or originates in a software
   * system different from the current system, for example a ProductOrder handed
   * off from a commerce platform into an order handling system. The structure
   * identifies the system itself, the nature of the entity within the system
   * (e.g. class name) and the unique ID of the entity within the system. It is
   * anticipated that multiple external IDs can be held for a single entity, e.g.
   * if the entity passed through multiple systems on the way to the current
   * system. In this case the consumer is expected to sequence the IDs in the
   * array in reverse order of provenance, i.e. most recent system first in the
   * list.
   */
  @JsonProperty("externalIdentifier")
  private List<@Valid ExternalIdentifier> externalIdentifiers;

  /**
   * Possible values for the impact of an Incident
   * <br/><p>Recommended values: extensive, significant, moderate, minor.
   *
   * @see org.opentmf.tmf724.model.ImpactType
   */
  private @SafeText String impact;

  /**
   * A textual succinct description of the nature, symptoms, cause, or effect of
   * the incident.
   */
  private @SafeText String incidentDetail;

  /**
   * Incident resolution suggestion or tip to resolve the incident.
   */
  private @SafeText String incidentResolutionSuggestion;

  /**
   * The name of the incident. A short-form string that provides succinct,
   * important information about the incident.
   */
  private @SafeText String name;

  /**
   * Indicates the time (as a date + time) at which the incident occurred at its
   * source.
   */
  private OffsetDateTime occurTime;

  /**
   * Possible values for the Priority of an Incident
   * <br/><p>Recommended values: critical, high, medium, low.
   *
   * @see org.opentmf.tmf724.model.PriorityType
   */
  private @SafeText String priority;

  /**
   * A root cause is a fundamental or underlying reason behind why an incident
   * occurred that identifies one or more failures. An incident many have multiple
   * rootCauses.
   */
  @JsonProperty("rootCause")
  private List<@Valid RootCause> rootCauses;

  /**
   * The root event object such as alarm, externalAlarm, performance, etc.
   */
  @JsonProperty("rootEventId")
  private List<@Valid ResourceEntity> rootEventIds;

  /**
   * The objects show the incident, it may be part of Network Equipment. Fault
   * object, which may be an NE or a port.
   */
  @JsonProperty("sourceObject")
  private @Size(min = 1) List<@Valid ResourceEntity> sourceObjects;

  /**
   * Possible values for the state of an Incident
   * <br/><p>Recommended values: raised, updated, cleared.
   *
   * @see org.opentmf.tmf724.model.IncidentStateType
   */
  private @SafeText String state;

  /**
   * The last update time of the incident.
   */
  private @SafeText String updateTime;

  /**
   * Possible values for the urgency of an Incident
   * <br/><p>Recommended values: critical, high, medium, low.
   *
   * @see org.opentmf.tmf724.model.UrgencyType
   */
  private @SafeText String urgency;
}