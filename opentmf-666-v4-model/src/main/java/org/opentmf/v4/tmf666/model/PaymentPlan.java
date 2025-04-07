package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.Money;
import org.opentmf.v4.common.model.TimePeriod;
import org.opentmf.v4.customer.model.PaymentMethodRef;

/**
 * Defines a plan for payment (when a party wants to spread his payments).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = PaymentPlan.class
)
public class PaymentPlan extends Extensible {

  /**
   * Number of payments used to spread the global payment.
   */
  private Integer numberOfPayments;

  /**
   * Frequency of the payments, such as monthly and bimonthly.
   */
  private @SafeText String paymentFrequency;

  /**
   * Type of payment plan.
   */
  private @SafeText String planType;

  /**
   * Priority of the payment plan.
   */
  private Integer priority;

  /**
   * Status of the payment plan (effective, ineffective).
   */
  private @SafeText String status;

  private @Valid PaymentMethodRef paymentMethod;

  /**
   * Amount paid.
   */
  private @Valid Money totalAmount;

  /**
   * Validity period of the payment plan.
   */
  private @Valid TimePeriod validFor;
}