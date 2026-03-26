package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.Place;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.ResourceRef;
import org.opentmf.common.model.ServiceProblemRef;
import org.opentmf.common.model.ServiceRef;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The problem information for Middle B which is abstracted in the service layer
 * from the issued event information by First B.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-717: Customer360 Management API</li>
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
    defaultImpl = Customer360ServiceProblemVO.class
)
public class Customer360ServiceProblemVO extends Entity implements ICustomer360ServiceProblemVO {

  /**
   * A list of the locations affected by the problem. At least one of
   * affectedResource, affectedService or affectedLocation should be present.
   */
  @JsonProperty("affectedLocation")
  private List<@Valid Place> affectedLocations;

  /**
   * Number of affected services.
   */
  private Integer affectedNumberOfServices;

  /**
   * List of affected services. At least one of affectedResource, affectedService
   * or affectedLocation should be present.
   */
  @JsonProperty("affectedService")
  private List<@Valid ServiceRef> affectedServices;

  /**
   * Classifier for the problem. Settable. For example, this is used for
   * distinguish the category of problem originator in [role].[category] format.
   * Example: serviceProvider.declarer, supplier.originated, system.originated.
   */
  private @SafeText String category;

  /**
   * Additional identifier coming from an external system.
   */
  @SafeId
  @Size(max = 100)
  private String correlationId;

  /**
   * Free form text describing the Service Problem.
   */
  private @SafeText String description;

  /**
   * A generic list of any type of elements. Used for vendor Extensions or loose
   * element encapsulation from other namespaces.
   */
  @JsonProperty("extensionInfo")
  private List<@Valid Characteristic> extensionInfoes;

  /**
   * Impact Importance is characterized by an Impact Importance Factor: overall
   * importance of the impact of all the affected services, e.g. 0 (zero impact)
   * to 100 (worst impact). The Impact Importance is a calculated field which is
   * set by the OSS determining the impact.
   */
  private @SafeText String impactImportanceFactor;

  /**
   * Indicates where the problem was generated.
   */
  private @SafeText String originatingSystem;

  /**
   * An indication varying from 1 (highest) to 10 (lowest) of how important it is
   * for the service provider to correct the Service Problem.
   */
  private Integer priority;

  /**
   * Indicates if this service problem has been escalated or not. Possible values
   * are 0 to 10. A value of zero means no escalation. The meanings of values 1-10
   * are to be determined by the user of the interface, but they show increasing
   * levels of escalation.
   */
  private @SafeText String problemEscalation;

  /**
   * Free text or optionally structured text. It can be Unknown.
   */
  private @SafeText String reason;

  /**
   * List of objects associated to this problem.
   */
  @JsonProperty("relatedObject")
  private List<@Valid RelatedEntityRef> relatedObjects;

  /**
   * List of parties or party roles playing a role within the service problem.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Time the problem was resolved.
   */
  private OffsetDateTime resolutionDate;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  private @Valid RelatedParty responsibleParty;

  /**
   * Resource(s) that are associated to the underlying service problems that are
   * the Root Cause of this one if any (used only if applicable).
   */
  @JsonProperty("rootCauseResource")
  private List<@Valid ResourceRef> rootCauseResources;

  /**
   * The current status of the service problem. Possible values are Submitted,
   * Rejected, Acknowledged, In Progress [Held, Pending], Resolved, Closed, and
   * Cancelled.
   */
  private @SafeText String status;

  /**
   * Time the problem was last status changed.
   */
  private OffsetDateTime statusChangeDate;

  /**
   * The reason of state change.
   */
  private @SafeText String statusChangeReason;

  /**
   * Time the problem was last changed.
   */
  private OffsetDateTime timeChanged;

  /**
   * Time the problem was raised.
   */
  private OffsetDateTime timeRaised;

  /**
   * A list of underlying problems. Relevant only if this problem is derived from
   * other problems.
   */
  @JsonProperty("underlyingProblem")
  private List<@Valid ServiceProblemRef> underlyingProblems;
}