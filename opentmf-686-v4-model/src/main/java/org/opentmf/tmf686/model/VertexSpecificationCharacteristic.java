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
 * This class defines the characteristic features of a vertex specification.
 * Every VertexSpecification has a variety of important attributes, methods,
 * constraints, and relationships, which distinguish a vertex specification from
 * other vertex specifications.
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
    defaultImpl = VertexSpecificationCharacteristic.class
)
public class VertexSpecificationCharacteristic extends CharacteristicSpecificationBase implements IVertexSpecificationCharacteristic {

  /**
   * An aggregation, migration, substitution, dependency or exclusivity
   * relationship between/among Specification Characteristics.
   */
  @JsonProperty("vertexSpecCharRelationship")
  private List<@Valid VertexSpecificationCharacteristicRelationship> vertexSpecCharRelationships;

  /**
   * A CharacteristicValueSpecification object is used to define a set of
   * attributes, each of which can be assigned to a corresponding set of
   * attributes in a VertexSpecificationCharacteristic object. The values of the
   * attributes in the CharacteristicValueSpecification object describe the values
   * of the attributes that a corresponding VertexSpecificationCharacteristic
   * object can take on.
   */
  @JsonProperty("vertexSpecCharacteristicValue")
  private List<@Valid CharacteristicValueSpecification> vertexSpecCharacteristicValues;
}