package org.opentmf.v4.tmf622.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A Product Order is a type of order which can be used to place an order
 * between a customer and a service provider or between a service provider and a
 * partner and vice versa,
 * <br/>Skipped properties: id,href,orderDate.
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
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ProductOrderUpdate.class
)
@Required(fields = {"productOrderItem"})
public class ProductOrderUpdate extends ProductOrderCreate {

  /**
   * Date when the order was completed.
   */
  private OffsetDateTime completionDate;

  /**
   * Expected delivery date amended by the provider.
   */
  private OffsetDateTime expectedCompletionDate;

  /**
   * Tracks the lifecycle status of the product order, such as Acknowledged,
   * Rejected, InProgress, Pending and so on.
   *
   * @see org.opentmf.v4.tmf622.model.ProductOrderStateType
   */
  private @SafeText String state;
}