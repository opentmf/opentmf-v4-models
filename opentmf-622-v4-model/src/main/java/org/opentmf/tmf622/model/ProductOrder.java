package org.opentmf.tmf622.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A Product Order is a type of order which can be used to place an order
 * between a customer and a service provider or between a service provider and a
 * partner and vice versa.
 *
 * <p><br/>
 * <strong>Required:</strong> productOrderItem<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
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
    defaultImpl = ProductOrder.class
)
@Required(fields = {"productOrderItem"})
public class ProductOrder extends ProductOrderUpdate implements IProductOrder {

  /**
   * Hyperlink to access the order.
   */
  private URI href;

  /**
   * ID created on repository side (OM system).
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Date when the order was created.
   */
  private OffsetDateTime orderDate;
}