package org.opentmf.v4.tmf622.model;

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
import org.opentmf.v4.common.model.AppointmentRef;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.ProductOfferingRef;
import org.opentmf.v4.product.model.BillingAccountRef;
import org.opentmf.v4.product.model.ProductOfferingQualificationItemRef;
import org.opentmf.v4.product.model.ProductOfferingQualificationRef;
import org.opentmf.v4.product.model.ProductRefOrValue;

/**
 * An identified part of the order. A product order is decomposed into one or
 * more order items.
 *
 * <p><br/>
 * <strong>Required:</strong> id, action<br/>
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
    defaultImpl = ProductOrderItem.class
)
@Required(fields = {"action", "id"})
public class ProductOrderItem extends Extensible {

  /**
   * Identifier of the line item (generally it is a sequence number 01, 02, 03,
   * ...).
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Quantity ordered.
   */
  private Integer quantity;

  /**
   * The action to be carried out on the Product. Can be: add, modify, delete,
   * noChange.
   *
   * @see org.opentmf.v4.common.model.OrderItemActionType
   */
  private @SafeText String action;

  private @Valid AppointmentRef appointment;

  private @Valid BillingAccountRef billingAccount;

  /**
   * List of: An amount, usually of money, that represents the actual price paid
   * by the Customer for this item or this order.
   */
  @JsonProperty("itemPrice")
  private List<@Valid OrderPrice> itemPrices;

  /**
   * List of: Description of a productTerm linked to this orderItem. This
   * represents a commitment with a duration.
   */
  @JsonProperty("itemTerm")
  private List<@Valid OrderTerm> itemTerms;

  /**
   * List of: An amount, usually of money, that represents the actual price paid
   * by the Customer for this item or this order.
   */
  @JsonProperty("itemTotalPrice")
  private List<@Valid OrderPrice> itemTotalPrices;

  /**
   * List of: If an immediate payment has been done at the product order
   * submission, the payment information are captured and stored (as a reference)
   * in the order.
   */
  @JsonProperty("payment")
  private List<@Valid PaymentRef> payments;

  private @Valid ProductRefOrValue product;

  private @Valid ProductOfferingRef productOffering;

  private @Valid ProductOfferingQualificationItemRef productOfferingQualificationItem;

  /**
   * List of: An identified part of the order. A product order is decomposed into
   * one or more order items.
   */
  @JsonProperty("productOrderItem")
  private List<@Valid ProductOrderItem> productOrderItems;

  @JsonProperty("productOrderItemRelationship")
  private List<@Valid OrderItemRelationship> productOrderItemRelationships;

  /**
   * List of: It's a productOfferingQualification that has been executed
   * previously.
   */
  @JsonProperty("qualification")
  private List<@Valid ProductOfferingQualificationRef> qualifications;

  private @Valid QuoteItemRef quoteItem;

  /**
   * State of the order item : described in the state machine diagram.
   *
   * @see org.opentmf.v4.tmf622.model.ProductOrderItemStateType
   */
  private @SafeText String state;
}