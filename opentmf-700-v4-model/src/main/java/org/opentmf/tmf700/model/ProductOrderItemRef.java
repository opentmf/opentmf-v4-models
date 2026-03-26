package org.opentmf.tmf700.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Reference to an order item that can typically be queried with another API.
 *
 * <p><br/>
 * <strong>Required:</strong> productOrderId<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-700: Shipping Order Management API</li>
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
    defaultImpl = ProductOrderItemRef.class
)
@Required(fields = {"productOrderId"})
public class ProductOrderItemRef extends EntityRef implements IProductOrderItemRef {

  /**
   * Identifier of the order of which the item is a part of.
   */
  @SafeId
  @Size(max = 100)
  private String productOrderId;
}