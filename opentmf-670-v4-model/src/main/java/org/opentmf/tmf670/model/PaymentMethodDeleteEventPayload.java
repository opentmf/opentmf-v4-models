package org.opentmf.tmf670.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.PaymentMethod;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-670: Payment Method Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PaymentMethodDeleteEventPayload implements IPaymentMethodDeleteEventPayload {

  /**
   * A Payment Method is a pure-virtual super-class that defines a specific method
   * of payment such as Direct Debit, Cash, Digital Wallet,Tokenized Card, Bank
   * Account Transfer, Bank Account Debit, Bank Card, Voucher, Check, Bucket
   * PaymentMethod, Account PaymentMethod, and Loyalty PaymentMethod with all
   * details associated. Use the {@literal @}type attribute to specify the concrete type in
   * the API calls.
   */
  private @Valid PaymentMethod paymentMethod;
}