package org.opentmf.tmf622.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AppointmentRef;
import org.opentmf.common.model.BillingAccountRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.common.model.ProductRefOrValue;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.customer.model.PaymentRef;
import org.opentmf.customer.model.ProductOfferingQualificationItemRef;
import org.opentmf.customer.model.ProductOfferingQualificationRef;

/**
 * An identified part of the order. A product order is decomposed into one or
 * more order items.
 *
 * <p><br/>
 * <strong>Required:</strong> action, id<br/>
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
    defaultImpl = ProductOrderItem.class
)
@Required(fields = {"action", "id"})
public class ProductOrderItem extends Extensible implements IProductOrderItem {

  /**
   * action to be performed on the product
   * <br/><p>Recommended values: add, modify, delete, noChange.
   *
   * @see org.opentmf.common.model.OrderItemActionType
   */
  private @SafeText String action;

  /**
   * Refers an appointment, such as a Customer presentation or internal meeting or
   * site visit.
   */
  private @Valid AppointmentRef appointment;

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * Identifier of the line item (generally it is a sequence number 01, 02, 03,
   * ...).
   */
  @SafeId
  @Size(max = 100)
  private String id;

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

  /**
   * A product to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the product entity and not the RelatedProductRefOrValue class itself.
   */
  private @Valid ProductRefOrValue product;

  /**
   * ProductOffering reference. A product offering represents entities that are
   * orderable from the provider of the catalog, this resource includes pricing
   * information.
   */
  private @Valid ProductOfferingRef productOffering;

  /**
   * It's a productOfferingQualification item that has been executed previously.
   */
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

  /**
   * Quantity ordered.
   */
  private Integer quantity;

  /**
   * It's a Quote item that has been executed previously.
   */
  private @Valid QuoteItemRef quoteItem;

  /**
   * Possible values for the state of the product order item
   * <br/><p>Recommended values: acknowledged, rejected, pending, held,
   * inProgress, cancelled, completed, failed, assessingCancellation,
   * pendingCancellation.
   *
   * @see org.opentmf.tmf622.model.ProductOrderItemStateType
   */
  private @SafeText String state;
}