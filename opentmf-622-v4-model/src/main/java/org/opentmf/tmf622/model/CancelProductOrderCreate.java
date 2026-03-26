package org.opentmf.tmf622.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ProductOrderRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Request for cancellation an existing product order
 * <br/>Skipped properties: id,href,state,effectiveCancellationDate.
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
    defaultImpl = CancelProductOrderCreate.class
)
@Required(fields = {"productOrder"})
public class CancelProductOrderCreate extends Extensible implements ICancelProductOrderCreate {

  /**
   * Reason why the order is cancelled.
   */
  private @SafeText String cancellationReason;

  /**
   * ProductOrder (ProductOrder) .The product order which the recommendation is
   * related with.
   */
  private @Valid ProductOrderRef productOrder;

  /**
   * Date when the submitter wants the order to be cancelled.
   */
  private OffsetDateTime requestedCancellationDate;
}