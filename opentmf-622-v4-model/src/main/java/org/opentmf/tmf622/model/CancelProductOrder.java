package org.opentmf.tmf622.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CancelOrder;
import org.opentmf.common.model.ProductOrderRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Request for cancellation an existing product order.
 *
 * <p><br/>
 * <strong>Required:</strong> productOrder<br/>
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
    defaultImpl = CancelProductOrder.class
)
@Required(fields = {"productOrder"})
public class CancelProductOrder extends CancelOrder implements ICancelProductOrder {

  /**
   * ProductOrder (ProductOrder) .The product order which the recommendation is
   * related with.
   */
  private @Valid ProductOrderRef productOrder;
}