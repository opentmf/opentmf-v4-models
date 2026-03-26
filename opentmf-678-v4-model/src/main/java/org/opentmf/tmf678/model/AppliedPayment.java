package org.opentmf.tmf678.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.Money;
import org.opentmf.customer.model.PaymentRef;

/**
 * The applied payment is the result of lettering process. It enables to assign
 * automatically or manually part of incoming payment amount to a bill.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-678: Customer Bill Management API</li>
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
    defaultImpl = AppliedPayment.class
)
public class AppliedPayment extends Extensible implements IAppliedPayment {

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money appliedAmount;

  /**
   * If an immediate payment has been done at the product order submission, the
   * payment information are captured and stored (as a reference) in the order.
   */
  private @Valid PaymentRef payment;
}