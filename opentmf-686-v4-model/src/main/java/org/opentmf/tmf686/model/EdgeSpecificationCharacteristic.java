package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CharacteristicSpecificationBase;
import org.opentmf.common.model.CharacteristicValueSpecification;

/**
 * This class defines the characteristic features of an edge specification.
 * Every EdgeSpecification has a variety of important attributes, methods,
 * constraints, and relationships, which distinguish an edge specification from
 * other edge specifications.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-686: Topology API</li>
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
    defaultImpl = EdgeSpecificationCharacteristic.class
)
public class EdgeSpecificationCharacteristic extends CharacteristicSpecificationBase implements IEdgeSpecificationCharacteristic {

  /**
   * An aggregation, migration, substitution, dependency or exclusivity
   * relationship between/among Specification Characteristics.
   */
  @JsonProperty("edgeSpecCharRelationship")
  private List<@Valid EdgeSpecificationCharacteristicRelationship> edgeSpecCharRelationships;

  /**
   * A CharacteristicValueSpecification object is used to define a set of
   * attributes, each of which can be assigned to a corresponding set of
   * attributes in a EdgeSpecificationCharacteristic object. The values of the
   * attributes in the CharacteristicValueSpecification object describe the values
   * of the attributes that a corresponding EdgeSpecificationCharacteristic object
   * can take on.
   */
  @JsonProperty("edgeSpecCharacteristicValue")
  private List<@Valid CharacteristicValueSpecification> edgeSpecCharacteristicValues;
}