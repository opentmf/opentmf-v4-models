package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * ServiceSpecification is a class that offers characteristics to describe a
 * type of service.
 * <br/>Functionally, it acts as a template by which Services may be
 * instantiated. By sharing the same specification, these services would
 * therefore share the same set of characteristics.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
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
    defaultImpl = ServiceSpecification.class
)
public class ServiceSpecification extends EntitySpecification implements IServiceSpecification {

  /**
   * A list of Features for this specification.
   */
  @JsonProperty("featureSpecification")
  private List<@Valid FeatureSpecification> featureSpecifications;

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
}