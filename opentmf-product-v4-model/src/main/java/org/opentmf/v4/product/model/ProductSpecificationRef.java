package org.opentmf.v4.product.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.EntityRef;

/**
 * Product specification reference: A ProductSpecification is a detailed
 * description of a tangible or intangible object made available externally in
 * the form of a ProductOffering to customers or other parties playing a party
 * role.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
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
    defaultImpl = ProductSpecificationRef.class
)
@Required(fields = {"id"})
public class ProductSpecificationRef extends EntityRef {

  /**
   * Version of the product specification.
   */
  private @SafeText String version;

  /**
   * A target product schema reference. The reference object to the schema and
   * type of target product which is described by product specification.
   */
  private @Valid TargetProductSchema targetProductSchema;
}