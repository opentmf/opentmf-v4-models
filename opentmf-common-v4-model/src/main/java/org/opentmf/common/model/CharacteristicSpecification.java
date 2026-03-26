package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * This class defines a characteristic specification.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-635: Usage Management API</li>
 *   <li>TMF-653: Service Test Management API</li>
 *   <li>TMF-662: Entity Catalog Management API</li>
 *   <li>TMF-667: Document Management API</li>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-701: Process Flow Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
 *   <li>TMF-713: Work Management</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-725: Metadata Catalog Management API</li>
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
    defaultImpl = CharacteristicSpecification.class
)
public class CharacteristicSpecification extends CharacteristicSpecificationBase implements ICharacteristicSpecification {

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