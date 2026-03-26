package org.opentmf.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CharacteristicSpecificationBase;
import org.opentmf.common.model.CharacteristicValueSpecification;

/**
 * A characteristic quality or distinctive feature of a ProductSpecification.
 * The characteristic can be take on a discrete value, such as color, can take
 * on a range of values, (for example, sensitivity of 100-240 mV), or can be
 * derived from a formula (for example, usage time (hrs) = 30 - talk time *3).
 * Certain characteristics, such as color, may be configured during the ordering
 * or some other process.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = ProductSpecificationCharacteristic.class
)
public class ProductSpecificationCharacteristic extends CharacteristicSpecificationBase implements IProductSpecificationCharacteristic {

  /**
   * An aggregation, migration, substitution, dependency or exclusivity
   * relationship between/among Specification Characteristics.
   */
  @JsonProperty("productSpecCharRelationship")
  private List<@Valid ProductSpecificationCharacteristicRelationship> productSpecCharRelationships;

  /**
   * A ProductSpecificationCharacteristicValue object is used to define a set of
   * attributes, each of which can be assigned to a corresponding set of
   * attributes in a ProductSpecificationCharacteristic object. The values of the
   * attributes in the ProductSpecificationCharacteristicValue object describe the
   * values of the attributes that a corresponding
   * ProductSpecificationCharacteristic object can take on.
   */
  @JsonProperty("productSpecCharacteristicValue")
  private List<@Valid CharacteristicValueSpecification> productSpecCharacteristicValues;
}