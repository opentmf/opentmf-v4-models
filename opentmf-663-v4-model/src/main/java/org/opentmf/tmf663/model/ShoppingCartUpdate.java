package org.opentmf.tmf663.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ContactMedium;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedParty;

/**
 * Shopping Cart resource is used for the temporarily selection and reservation
 * of product offerings in e-commerce, call center and retail purchase. Shopping
 * cart supports purchase of both physical and digital goods and service (e.g.
 * handset, telecom network service). Shopping Cart contain list of cart items,
 * a reference to customer (partyRole) or contact medium in case customer not
 * exist, and the total items price including promotions
 * <br/>Skipped properties: id,href,validFor,cartTotalPrice.
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
    defaultImpl = ShoppingCartUpdate.class
)
public class ShoppingCartUpdate extends Extensible implements IShoppingCartUpdate {

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
   * List of: Indicates the contact medium that could be used to contact the
   * party.
   */
  @JsonProperty("contactMedium")
  private List<@Valid ContactMedium> contactMediums;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;
}