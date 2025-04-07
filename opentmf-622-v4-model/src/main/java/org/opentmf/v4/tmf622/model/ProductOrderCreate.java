package org.opentmf.v4.tmf622.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AgreementRef;
import org.opentmf.v4.common.model.OrderBase;
import org.opentmf.v4.common.model.RelatedChannel;
import org.opentmf.v4.product.model.BillingAccountRef;
import org.opentmf.v4.product.model.ProductOfferingQualificationRef;

/**
 * A Product Order is a type of order which can be used to place an order
 * between a customer and a service provider or between a service provider and a
 * partner and vice versa,
 * <br/>Skipped properties:
 * id,href,completionDate,orderDate,state,expectedCompletionDate,productOrderItem.state.
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
    defaultImpl = ProductOrderCreate.class
)
@Required(fields = {"productOrderItem"})
public class ProductOrderCreate extends OrderBase {

  /**
   * Date when the order is cancelled. This is used when order is cancelled.
   */
  private OffsetDateTime cancellationDate;

  /**
   * Reason why the order is cancelled. This is used when order is cancelled.
   */
  private @SafeText String cancellationReason;

  /**
   * Used to categorize the order from a business perspective that can be useful
   * for the OM system (e.g. "enterprise", "residential", ...).
   */
  private @SafeText String category;

  /**
   * Contact attached to the order to send back information regarding this order.
   */
  private @SafeText String notificationContact;

  /**
   * A way that can be used by consumers to prioritize orders in OM system (from 0
   * to 4 : 0 is the highest priority, and 4 the lowest).
   */
  private @SafeText String priority;

  /**
   * A reference to an agreement defined in the context of the product order.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

  private @Valid BillingAccountRef billingAccount;

  /**
   * List of: Related channel to another entity. May be online web, mobile app,
   * social ,etc.
   */
  @JsonProperty("channel")
  private List<@Valid RelatedChannel> channels;

  /**
   * List of: An amount, usually of money, that represents the actual price paid
   * by the Customer for this item or this order.
   */
  @JsonProperty("orderTotalPrice")
  private List<@Valid OrderPrice> orderTotalPrices;

  /**
   * List of: If an immediate payment has been done at the product order
   * submission, the payment information are captured and stored (as a reference)
   * in the order.
   */
  @JsonProperty("payment")
  private List<@Valid PaymentRef> payments;

  /**
   * List of: It's a productOfferingQualification that has been executed
   * previously.
   */
  @JsonProperty("productOfferingQualification")
  private List<@Valid ProductOfferingQualificationRef> productOfferingQualifications;

  /**
   * List of: An identified part of the order. A product order is decomposed into
   * one or more order items.
   */
  @JsonProperty("productOrderItem")
  private @Size(min = 1) List<@Valid ProductOrderItem> productOrderItems;

  /**
   * List of: It's a Quote that has been executed previously.
   */
  @JsonProperty("quote")
  private List<@Valid QuoteRef> quotes;
}