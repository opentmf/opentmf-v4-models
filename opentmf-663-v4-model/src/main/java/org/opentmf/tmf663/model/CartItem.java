package org.opentmf.tmf663.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CartItemRelationship;
import org.opentmf.common.model.CartTerm;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.common.model.ProductRefOrValue;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An identified part of the shopping cart. A shopping cart is decomposed into
 * one or more shopping cart item. Cart item represents a product offering or
 * bundled product offering that user wish to purchase, as well as the pricing
 * of the product offering, reference to product in case of configured
 * characteristic or installation address. Cart items can be related to other
 * cart item to related bundled offerings or reference cart Items to a shipping
 * options.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-663: Shopping Cart Management API</li>
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
    defaultImpl = CartItem.class
)
public class CartItem extends Extensible implements ICartItem {

  /**
   * List of: An amount, usually of money, that represents the actual price paid
   * by the customer for this item. May represent the total price of the shopping
   * cart or the total of the cart item depending on the relation.
   */
  @JsonProperty("ItemTotalPrice")
  private List<@Valid CartPrice> itemTotalPrices;

  /**
   * action to be performed on the product
   * <br/><p>Recommended values: add, modify, delete, noChange.
   *
   * @see org.opentmf.tmf663.model.CartItemActionType
   */
  private @SafeText String action;

  /**
   * List of: An identified part of the shopping cart. A shopping cart is
   * decomposed into one or more shopping cart item. Cart item represents a
   * product offering or bundled product offering that user wish to purchase, as
   * well as the pricing of the product offering, reference to product in case of
   * configured characteristic or installation address. Cart items can be related
   * to other cart item to related bundled offerings or reference cart Items to a
   * shipping options.
   */
  @JsonProperty("cartItem")
  private List<@Valid CartItem> cartItems;

  /**
   * List of: Relationship among cart items mainly other than hierarchical
   * relationships such as "RelyOn", "DependentOn", "Shipping" etc.
   */
  @JsonProperty("cartItemRelationship")
  private List<@Valid CartItemRelationship> cartItemRelationships;

  /**
   * Identifier of the cart item (generally it is a sequence number 01, 02, 03,
   * ...) in the shopping cart.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * List of: An amount, usually of money, that represents the actual price paid
   * by the customer for this item. May represent the total price of the shopping
   * cart or the total of the cart item depending on the relation.
   */
  @JsonProperty("itemPrice")
  private List<@Valid CartPrice> itemPrices;

  @JsonProperty("itemTerm")
  private List<@Valid CartTerm> itemTerms;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

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
   * Quantity of cart items.
   */
  private Integer quantity;

  /**
   * Possible values for the status of the cart item
   * <br/><p>Recommended values: active, saveForLater.
   *
   * @see org.opentmf.tmf663.model.CartItemStatusType
   */
  private @SafeText String status;
}