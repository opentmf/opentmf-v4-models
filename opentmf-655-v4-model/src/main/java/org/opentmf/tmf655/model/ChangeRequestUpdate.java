package org.opentmf.tmf655.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.ExternalReference;
import org.opentmf.common.model.Money;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.RelatedEntity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.RelatedPlaceRefOrValue;
import org.opentmf.common.model.SLARef;
import org.opentmf.common.model.ServiceProblemRef;
import org.opentmf.common.model.TroubleTicketRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.general.model.EntitySpecificationRef;

/**
 * Change Request is a type of request which can be used for the management and
 * control of Change Management process 
 * <br/> -within a service provider organisation or 
 * <br/> -between a customer and a service provider or 
 * <br/> -between a service provider and a partner and vice versa.
 * <br/>Skipped properties: id,href,{@literal @}baseType,{@literal @}schemaLocation,{@literal @}type.
 *
 * <p><br/>
 * <strong>Required:</strong> targetEntity<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-655: Change Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@Required(fields = {"targetEntity"})
public class ChangeRequestUpdate implements IChangeRequestUpdate {

  /**
   * Date and time when the change implementation actually finished.
   */
  private OffsetDateTime actualEndTime;

  /**
   * Date and time when the change implementation actually started.
   */
  private OffsetDateTime actualStartTime;

  /**
   * The attachments of the communication message (when it is email type).
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money budget;

  @JsonProperty("changeRelationship")
  private List<@Valid ChangeRequestRelationship> changeRelationships;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("changeRequestCharacteristic")
  private List<@Valid Characteristic> changeRequestCharacteristics;

  /**
   * A channel represents the way the Change Request was created.
   */
  private @SafeText String channel;

  /**
   * Date and time when the change request is confirmed to be completed.
   */
  private OffsetDateTime completionDate;

  /**
   * Description of the change request.
   */
  private @SafeText String description;

  /**
   * List of: External reference of the individual or reference in other system.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * Indicates the impact of this change.
   */
  private @SafeText String impact;

  /**
   * List of: A reference to an imapcted entity.
   */
  @JsonProperty("impactEntity")
  private List<@Valid ImpactEntity> impactEntities;

  /**
   * Date and time when the change request was updated.
   */
  private OffsetDateTime lastUpdateDate;

  /**
   * Related Entity reference. A related place defines a place described by
   * reference or by value linked to a specific entity. The polymorphic attributes
   * {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place entity and
   * not the RelatedPlaceRefOrValue class itself.
   */
  private @Valid RelatedPlaceRefOrValue location;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Date and time when the change implementation is planned to be finished.
   */
  private OffsetDateTime plannedEndTime;

  /**
   * Date and time when the change implementation is planned to be started.
   */
  private OffsetDateTime plannedStartTime;

  /**
   * Used by consumers to prioritize a change request in Change Management system.
   */
  private @SafeText String priority;

  @JsonProperty("problemTicket")
  private List<@Valid ServiceProblemRef> problemTickets;

  /**
   * The parties involved in the change request.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Date and time when the change request is raised.
   */
  private OffsetDateTime requestDate;

  /**
   * Indicates the type of the change request.
   */
  private @SafeText String requestType;

  /**
   * The way one or more change request has been implementation through a direct
   * remedy or task.
   */
  private @Valid Resolution resolution;

  /**
   * The risk to implement this change request.
   */
  private @SafeText String risk;

  /**
   * The risk mitigation plan.
   */
  private @SafeText String riskMitigationPlan;

  /**
   * The additional cost if the risk will happen.
   */
  private @SafeText String riskValue;

  /**
   * Date and time that the schedule is made.
   */
  private OffsetDateTime scheduledDate;

  /**
   * List of: ServiceLevelAgreement reference: A service level agreement (SLA) is
   * a type of agreement that represents a formal negotiated agreement between two
   * parties designed to create a common understanding about products, services,
   * priorities, responsibilities, and so forth. The SLA is a set of appropriate
   * procedures and targets formally or informally agreed between parties in order
   * to achieve and maintain specified Quality of Service.
   */
  @JsonProperty("sla")
  private List<@Valid SLARef> slas;

  /**
   * reference to an EntitySpecification object.
   */
  private @Valid EntitySpecificationRef specification;

  /**
   * Possible values for the state of the change request
   * <br/><p>Recommended values: acknowledged, requestForAuthorization,
   * waitForApproval, approved, scheduled, postImplementationReview,
   * fallbackExecution, cancelled, rejected, inProgress, failed, completed.
   *
   * @see org.opentmf.tmf655.model.ChangeRequestStatusType
   */
  private @SafeText String status;

  /**
   * Date and time when the change request status was changed.
   */
  private OffsetDateTime statusChangeDate;

  /**
   * Reason of the status change.
   */
  private @SafeText String statusChangeReason;

  /**
   * List of: A reference to an entity, where the type of the entity is not known
   * in advance.
   */
  @JsonProperty("targetEntity")
  private @Size(min = 1) List<@Valid RelatedEntity> targetEntities;

  /**
   * List of: TroubleTicket reference, for when a Trouble Ticket is used by other
   * entities.
   */
  @JsonProperty("troubleTicket")
  private List<@Valid TroubleTicketRef> troubleTickets;

  /**
   * List of: A record of the work performed on the change request during the
   * investigation and resolution process.
   */
  @JsonProperty("workLog")
  private List<@Valid WorkLog> workLogs;
}