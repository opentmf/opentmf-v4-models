package org.opentmf.v4.tmf634.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AttachmentRefOrValue;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.FeatureSpecification;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * Resources are physical or non-physical components (or some combination of
 * these) within an enterprise's infrastructure or inventory. They are typically
 * consumed or used by services (for example a physical port assigned to a
 * service) or contribute to the realization of a Product (for example, a SIM
 * card). They can be drawn from the Application, Computing and Network domains,
 * and include, for example, Network Elements, software, IT systems, content and
 * information, and technology components.
 * <br/>A ResourceSpecification is a base class that represents a generic means
 * for implementing a particular type of Resource. In essence, a
 * ResourceSpecification defines the common attributes and relationships of a
 * set of related Resources, while Resource defines a specific instance that is
 * based on a particular ResourceSpecification.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ResourceSpecificationCreate.class
)
@Required(fields = {"name"})
public class ResourceSpecificationCreate extends Extensible {

  /**
   * Category of the target resource like NetworkConnectivity, PhysicalLinks,
   * Generic, L2Network and so on.
   */
  private @SafeText String category;

  /**
   * Description of this REST resource.
   */
  private @SafeText String description;

  /**
   * A flag indicates that if this resource specification is a bundled
   * specification (true) or single (false).
   */
  private Boolean isBundle;

  /**
   * Date and time of the last update of this REST resource.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Used to indicate the current lifecycle status of the resource specification.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name given to this REST resource.
   */
  private @SafeText String name;

  /**
   * Resource Specification version.
   */
  private @SafeText String version;

  /**
   * Complements the description of an element (for instance a resource) through
   * video, pictures ...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * A list of Features for this specification.
   */
  @JsonProperty("featureSpecification")
  private List<@Valid FeatureSpecification> featureSpecifications;

  /**
   * A related party defines party or party role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A characteristic quality or distinctive feature of a ResourceSpecification.
   * The characteristic can be take on a discrete value, such as color, can take
   * on a range of values, (for example, sensitivity of 100-240 mV), or can be
   * derived from a formula (for example, usage time (hrs) = 30 - talk time *3).
   * Certain characteristics, such as color, may be configured during the ordering
   * or some other process.
   */
  @JsonProperty("resourceSpecCharacteristic")
  private List<@Valid ResourceSpecificationCharacteristic> resourceSpecCharacteristics;

  /**
   * A migration, substitution, dependency or exclusivity relationship
   * between/among resource specifications.
   */
  @JsonProperty("resourceSpecRelationship")
  private List<@Valid ResourceSpecificationRelationship> resourceSpecRelationships;

  /**
   * A target resource schema reference. The reference object to the schema and
   * type of target resource which is described by resource specification.
   */
  private @Valid TargetResourceSchema targetResourceSchema;

  /**
   * The period for which this REST resource is valid.
   */
  private @Valid TimePeriod validFor;
}