package org.opentmf.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.FeatureSpecification;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.ResourceSpecificationCreateBase;
import org.opentmf.commons.validation.constraints.SafeText;

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
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
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
    defaultImpl = ResourceSpecificationUpdate.class
)
public class ResourceSpecificationUpdate extends ResourceSpecificationCreateBase implements IResourceSpecificationUpdate {

  /**
   * Complements the description of an element (for instance a resource) through
   * video, pictures ...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Category of the target resource like NetworkConnectivity, PhysicalLinks,
   * Generic, L2Network and so on.
   */
  private @SafeText String category;

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
   * The reference object to the schema and type of target resource which is
   * described by resource specification.
   */
  private @Valid TargetResourceSchema targetResourceSchema;
}