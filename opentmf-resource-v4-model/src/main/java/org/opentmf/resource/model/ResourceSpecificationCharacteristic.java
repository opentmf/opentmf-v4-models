package org.opentmf.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CharacteristicSpecificationBase;
import org.opentmf.common.model.CharacteristicValueSpecification;

/**
 * This class defines the characteristic features of a resource specification.
 * Every ResourceSpecification has a variety of important attributes, methods,
 * constraints, and
 * <br/>relationships, which distinguish a resource specification from other
 * resource specifications.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
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
    defaultImpl = ResourceSpecificationCharacteristic.class
)
public class ResourceSpecificationCharacteristic extends CharacteristicSpecificationBase implements IResourceSpecificationCharacteristic {

  /**
   * An aggregation, migration, substitution, dependency or exclusivity
   * relationship between/among Specification Characteristics.
   */
  @JsonProperty("resourceSpecCharRelationship")
  private List<@Valid ResourceSpecificationCharacteristicRelationship> resourceSpecCharRelationships;

  /**
   * A CharacteristicValueSpecification object is used to define a set of
   * attributes, each of which can be assigned to a corresponding set of
   * attributes in a ResourceSpecificationCharacteristic object. The values of the
   * attributes in the CharacteristicValueSpecification object describe the values
   * of the attributes that a corresponding ResourceSpecificationCharacteristic
   * object can take on.
   */
  @JsonProperty("resourceSpecCharacteristicValue")
  private List<@Valid CharacteristicValueSpecification> resourceSpecCharacteristicValues;
}