package org.opentmf.tmf915.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.FeatureSpecification;
import org.opentmf.common.model.ResourceSpecificationRef;
import org.opentmf.common.model.ServiceLevelSpecificationRef;
import org.opentmf.common.model.ServiceSpecRelationship;

/**
 * AiModelSpecification is a class that offers characteristics to describe a
 * type of service.
 * <br/>Functionally, it acts as a template by which Services may be
 * instantiated. By sharing the same specification, these services would
 * therefore share the same set of characteristics.
 * <br/>Skipped properties: id,href,lastUpdate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = AiModelSpecificationUpdate.class
)
public class AiModelSpecificationUpdate extends AiContractSpecificationUpdate implements IAiModelSpecificationUpdate {

  private Object deploymentRecord;

  /**
   * A list of Features for this specification.
   */
  @JsonProperty("featureSpecification")
  private List<@Valid FeatureSpecification> featureSpecifications;

  private Object inheritedModel;

  private Object modelContractVersionHistory;

  private Object modelDataSheet;

  private Object modelEvaluationData;

  private Object modelSpecificationHistory;

  private Object modelTrainingData;

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