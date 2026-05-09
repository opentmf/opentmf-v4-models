package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * RelatedProductOrderItem (ProductOrder item) .The product order item which
 * triggered product creation/change/termination.
 *
 * <p><br/>
 * <strong>Required:</strong> orderItemId, productOrderId<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
 *   <li>TMF-680: Recommendation Management API</li>
 *   <li>TMF-687: Stock Management API</li>
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
    defaultImpl = RelatedProductOrderItem.class
)
@Required(fields = {"orderItemId", "productOrderId"})
public class RelatedProductOrderItem extends ShoppingCartRef implements IRelatedProductOrderItem {

  /**
   * Action of the order item for this product.
   */
  private @SafeText String orderItemAction;

  /**
   * Identifier of the order item where the product was managed.
   */
  @SafeId
  @Size(max = 100)
  private String orderItemId;

  /**
   * Reference of the related entity.
   */
  private URI productOrderHref;

  /**
   * Unique identifier of a related entity.
   */
  @SafeId
  @Size(max = 100)
  private String productOrderId;

  /**
   * role of the product order item for this product.
   */
  private @SafeText String role;
}