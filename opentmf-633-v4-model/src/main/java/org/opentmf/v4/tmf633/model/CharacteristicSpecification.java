package org.opentmf.v4.tmf633.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.common.model.CharacteristicSpecificationBase;
import org.opentmf.v4.common.model.CharacteristicValueSpecification;

/**
 * This class defines a characteristic specification.
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
    defaultImpl = CharacteristicSpecification.class
)
public class CharacteristicSpecification extends CharacteristicSpecificationBase {

  /**
   * An aggregation, migration, substitution, dependency or exclusivity
   * relationship between/among Specification Characteristics.
   */
  @JsonProperty("charSpecRelationship")
  private List<@Valid CharacteristicSpecificationRelationship> charSpecRelationships;

  /**
   * A CharacteristicValueSpecification object is used to define a set of
   * attributes, each of which can be assigned to a corresponding set of
   * attributes in a CharacteristicSpecification object. The values of the
   * attributes in the CharacteristicValueSpecification object describe the values
   * of the attributes that a corresponding Characteristic object can take on.
   */
  @JsonProperty("characteristicValueSpecification")
  private List<@Valid CharacteristicValueSpecification> characteristicValueSpecifications;
}