package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

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
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
 *   <li>TMF-680: Recommendation Management API</li>
 *   <li>TMF-687: Stock Management API</li>
 *   <li>TMF-699: Sales Management API</li>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-717: Customer360 Management API</li>
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
    defaultImpl = ProductSpecificationRef.class
)
@Required(fields = {"id"})
public class ProductSpecificationRef extends ServiceSpecificationRef implements IProductSpecificationRef {

  /**
   * The reference object to the schema and type of target product which is
   * described by product specification.
   */
  private @Valid TargetProductSchema targetProductSchema;
}