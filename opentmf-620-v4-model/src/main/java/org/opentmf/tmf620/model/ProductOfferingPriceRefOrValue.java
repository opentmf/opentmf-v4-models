package org.opentmf.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A new product offering price being created by value or a reference to an
 * existing product offering price that already created. The polymorphic
 * attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the product
 * offering price and not to this ReforValue structure.
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
    defaultImpl = ProductOfferingPriceRefOrValue.class
)
public class ProductOfferingPriceRefOrValue extends POPCharge implements IProductOfferingPriceRefOrValue {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;
}