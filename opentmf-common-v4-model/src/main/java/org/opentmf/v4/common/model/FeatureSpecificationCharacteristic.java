package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Configuration feature characteristic specification.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
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
    defaultImpl = FeatureSpecificationCharacteristic.class
)
@Required(fields = {"name"})
public class FeatureSpecificationCharacteristic extends CharacteristicSpecificationBase {

  /**
   * An aggregation, migration, substitution, dependency or exclusivity
   * relationship between/among feature characteristics.
   */
  @JsonProperty("featureSpecCharRelationship")
  private List<@Valid FeatureSpecificationCharacteristicRelationship> featureSpecCharRelationships;

  /**
   * Used to define a set of attributes, each of which can be assigned to a
   * corresponding set of attributes in a FeatureCharacteristic object.
   */
  @JsonProperty("featureSpecCharacteristicValue")
  private List<@Valid CharacteristicValueSpecification> featureSpecCharacteristicValues;
}