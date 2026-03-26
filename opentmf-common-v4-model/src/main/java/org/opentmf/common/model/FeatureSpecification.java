package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Specification for resource, service or product features.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
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
    defaultImpl = FeatureSpecification.class
)
public class FeatureSpecification extends NamedEntity implements IFeatureSpecification {

  /**
   * This is a list of feature constraints.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  /**
   * This is a list of characteristics for a particular feature.
   */
  @JsonProperty("featureSpecCharacteristic")
  private List<@Valid FeatureSpecificationCharacteristic> featureSpecCharacteristics;

  /**
   * A dependency, exclusivity or aggregation relationship between/among feature
   * specifications.
   */
  @JsonProperty("featureSpecRelationship")
  private List<@Valid FeatureSpecificationRelationship> featureSpecRelationships;

  /**
   * A flag indicating if this is a feature group (true) or not (false).
   */
  private Boolean isBundle;

  /**
   * A flag indicating if the feature is enabled (true) or not (false).
   */
  private Boolean isEnabled;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * Version of the feature specification.
   */
  private @SafeText String version;
}