package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * The paymentItem is the result of lettering process. It enables to assign
 * automatically or manually part of incoming payment amount to a bill.
 *
 * <p><br/>
 * <strong>Required:</strong> item<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-676: Payment Management API</li>
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
    defaultImpl = PaymentItem.class
)
@Required(fields = {"item"})
public class PaymentItem extends Entity implements IPaymentItem {

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money amount;

  /**
   * Entity reference schema to be used for all entityRef class.
   */
  private @Valid EntityRef item;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money taxAmount;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money totalAmount;
}