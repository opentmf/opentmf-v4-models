package org.opentmf.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CharacteristicValueSpecification;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ProductSpecificationRef;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A use of the ProductSpecificationCharacteristicValue by a ProductOffering to
 * which additional properties (attributes) apply or override the properties of
 * similar properties contained in ProductSpecificationCharacteristicValue. It
 * should be noted that characteristics which their value(s) addressed by this
 * object must exist in corresponding product specification. The available
 * characteristic values for a ProductSpecificationCharacteristic in a Product
 * specification can be modified at the ProductOffering level. For example, a
 * characteristic 'Color' might have values White, Blue, Green, and Red. But,
 * the list of values can be restricted to e.g. White and Blue in an associated
 * product offering. It should be noted that the list of values in
 * 'ProductSpecificationCharacteristicValueUse' is a strict subset of the list
 * of values as defined in the corresponding product specification
 * characteristics.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = ProductSpecificationCharacteristicValueUse.class
)
public class ProductSpecificationCharacteristicValueUse extends Extensible implements IProductSpecificationCharacteristicValueUse {

  /**
   * A narrative that explains in detail what the
   * productSpecificationCharacteristic is.
   */
  private @SafeText String description;

  /**
   * Unique ID for the characteristic.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * The maximum number of instances a CharacteristicValue can take on. For
   * example, zero to five phone numbers in a group calling plan, where five is
   * the value for the maxCardinality.
   */
  private Integer maxCardinality;

  /**
   * The minimum number of instances a CharacteristicValue can take on. For
   * example, zero to five phone numbers in a group calling plan, where zero is
   * the value for the minCardinality.
   */
  private Integer minCardinality;

  /**
   * Name of the associated productSpecificationCharacteristic.
   */
  private @SafeText String name;

  /**
   * A number or text that can be assigned to a
   * ProductSpecificationCharacteristic.
   */
  @JsonProperty("productSpecCharacteristicValue")
  private List<@Valid CharacteristicValueSpecification> productSpecCharacteristicValues;

  /**
   * Product specification reference: A ProductSpecification is a detailed
   * description of a tangible or intangible object made available externally in
   * the form of a ProductOffering to customers or other parties playing a party
   * role.
   */
  private @Valid ProductSpecificationRef productSpecification;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * A kind of value that the characteristic can take on, such as numeric, text
   * and so forth.
   */
  private @SafeText String valueType;
}