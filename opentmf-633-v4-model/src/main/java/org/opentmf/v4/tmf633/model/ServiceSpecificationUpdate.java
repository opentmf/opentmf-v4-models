package org.opentmf.v4.tmf633.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AttachmentRefOrValue;
import org.opentmf.v4.common.model.ConstraintRef;
import org.opentmf.v4.common.model.EntitySpecificationRelationship;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.FeatureSpecification;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.common.model.ResourceSpecificationRef;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * ServiceSpecification is a class that offers characteristics to describe a
 * type of service.
 * <br/>Functionally, it acts as a template by which Services may be
 * instantiated. By sharing the same specification, these services would
 * therefore share the same set of characteristics.
 * <br/>Skipped properties: id,href,lastUpdate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
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
    defaultImpl = ServiceSpecificationUpdate.class
)
public class ServiceSpecificationUpdate extends Extensible {

  /**
   * Description of the specification.
   */
  private @SafeText String description;

  /**
   * isBundle determines whether specification represents a single specification
   * (false), or a bundle of specifications (true).
   */
  private Boolean isBundle;

  /**
   * Used to indicate the current lifecycle status of this catalog item.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name given to the specification.
   */
  private @SafeText String name;

  /**
   * specification version.
   */
  private @SafeText String version;

  /**
   * Attachments that may be of relevance to this specification, such as picture,
   * document, media.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * This is a list of constraint references applied to this specification.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  /**
   * Relationship to another specification.
   */
  @JsonProperty("entitySpecRelationship")
  private List<@Valid EntitySpecificationRelationship> entitySpecRelationships;

  /**
   * A list of Features for this specification.
   */
  @JsonProperty("featureSpecification")
  private List<@Valid FeatureSpecification> featureSpecifications;

  /**
   * Parties who manage or otherwise have an interest in this specification.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A list of resource specification references (ResourceSpecificationRef [*]).
   * The ResourceSpecification is required for a service specification with type
   * ResourceFacingServiceSpecification (RFSS).
   */
  @JsonProperty("resourceSpecification")
  private List<@Valid ResourceSpecificationRef> resourceSpecifications;

  /**
   * A list of service level specifications related to this service specification,
   * and which will need to be satisfiable for corresponding service instances;
   * e.g. Gold, Platinum.
   */
  @JsonProperty("serviceLevelSpecification")
  private List<@Valid ServiceLevelSpecificationRef> serviceLevelSpecifications;

  /**
   * A list of service specifications related to this specification, e.g.
   * migration, substitution, dependency or exclusivity relationship.
   */
  @JsonProperty("serviceSpecRelationship")
  private List<@Valid ServiceSpecRelationship> serviceSpecRelationships;

  /**
   * List of characteristics that the entity can take.
   */
  @JsonProperty("specCharacteristic")
  private List<@Valid CharacteristicSpecification> specCharacteristics;

  /**
   * Pointer to a schema that defines the target entity.
   */
  private @Valid TargetEntitySchema targetEntitySchema;

  /**
   * The period for which this REST resource is valid.
   */
  private @Valid TimePeriod validFor;
}