package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An aggregation, migration, substitution, dependency or exclusivity
 * relationship between/among FeatureSpecificationCharacteristics.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
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
    defaultImpl = FeatureSpecificationCharacteristicRelationship.class
)
public class FeatureSpecificationCharacteristicRelationship extends NamedEntity {

  /**
   * Unique identifier of the characteristic within the the target feature
   * specification.
   */
  @SafeId
  @Size(max = 100)
  private String characteristicId;

  /**
   * Unique identifier of the target feature specification within the resource
   * specification.
   */
  @SafeId
  @Size(max = 100)
  private String featureId;

  /**
   * Type of relationship such as aggregation, migration, substitution,
   * dependency, exclusivity.
   */
  private @SafeText String relationshipType;

  /**
   * Hyperlink reference to the resource specification containing the target
   * feature and feature characteristic.
   */
  private URI resourceSpecificationHref;

  /**
   * Unique identifier of the resource specification containing the target feature
   * and feature characteristic.
   */
  @SafeId
  @Size(max = 100)
  private String resourceSpecificationId;

  /**
   * The period for which the object is valid.
   */
  private @Valid TimePeriod validFor;
}