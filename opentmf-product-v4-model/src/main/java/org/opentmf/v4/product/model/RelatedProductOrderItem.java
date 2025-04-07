package org.opentmf.v4.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;

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
    defaultImpl = RelatedProductOrderItem.class
)
@Required(fields = {"orderItemId", "productOrderId"})
public class RelatedProductOrderItem extends Extensible {

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

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;
}