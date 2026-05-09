package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The Payment resource represents a performed payment. It contains both
 * information about the payment and the payment method used to perform it.
 * <br/>Skipped properties: id,href,status,statusDate,paymentDate.
 *
 * <p><br/>
 * <strong>Required:</strong> account, paymentMethod, totalAmount<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = PaymentCreate.class
)
@Required(fields = {"totalAmount", "paymentMethod", "account"})
public class PaymentCreate extends Extensible implements IPaymentCreate {

  /**
   * Account reference. An account may be a party account or a financial account.
   */
  private @Valid AccountRef account;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money amount;

  /**
   * Authorization code retrieved from an external payment gateway that could be
   * used for conciliation.
   */
  private @SafeText String authorizationCode;

  /**
   * The channel to which the resource reference to. e.g. channel for selling
   * product offerings, channel for opening a trouble ticket etc..
   */
  private @Valid ChannelRef channel;

  /**
   * Unique identifier in the client for the payment in case it is needed to
   * correlate.
   */
  @SafeId
  @Size(max = 100)
  private String correlatorId;

  /**
   * Text describing the contents of the payment.
   */
  private @SafeText String description;

  /**
   * Screen name of the payment.
   */
  private @SafeText String name;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  private @Valid RelatedParty payer;

  /**
   * List of: The paymentItem is the result of lettering process. It enables to
   * assign automatically or manually part of incoming payment amount to a bill.
   */
  @JsonProperty("paymentItem")
  private List<@Valid PaymentItem> paymentItems;

  /**
   * link to the resource that holds information about the payment mean used to
   * complete the operation.
   */
  private @Valid PaymentMethodRefOrValue paymentMethod;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money taxAmount;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money totalAmount;
}