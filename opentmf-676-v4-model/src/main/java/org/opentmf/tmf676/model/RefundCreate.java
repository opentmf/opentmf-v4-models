package org.opentmf.tmf676.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AccountRef;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.Money;
import org.opentmf.common.model.PaymentMethodRefOrValue;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.customer.model.PaymentRef;

/**
 * The Refund resource represents a performed Refund. It contains both
 * information about the refund and the payment method used to perform it.
 * <br/>Skipped properties: id,href,status,statusDate,RefundDate.
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
    defaultImpl = RefundCreate.class
)
@Required(fields = {"totalAmount", "paymentMethod", "account"})
public class RefundCreate extends Extensible implements IRefundCreate {

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
   * Unique identifier in the client for the refund in case it is needed to
   * correlate.
   */
  @SafeId
  @Size(max = 100)
  private String correlatorId;

  /**
   * Text describing the contents of the refund.
   */
  private @SafeText String description;

  /**
   * Screen name of the refund.
   */
  private @SafeText String name;

  /**
   * If an immediate payment has been done at the product order submission, the
   * payment information are captured and stored (as a reference) in the order.
   */
  private @Valid PaymentRef payment;

  /**
   * link to the resource that holds information about the payment mean used to
   * complete the operation.
   */
  private @Valid PaymentMethodRefOrValue paymentMethod;

  /**
   * Date when the refund was performed.
   */
  private OffsetDateTime refundDate;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  @JsonProperty("requestor")
  private @Valid RelatedParty requester;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money taxAmount;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money totalAmount;
}