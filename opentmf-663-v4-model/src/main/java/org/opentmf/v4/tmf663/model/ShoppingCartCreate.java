package org.opentmf.v4.tmf663.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * Shopping Cart resource is used for the temporarily selection and reservation
 * of product offerings in e-commerce, call center and retail purchase. Shopping
 * cart supports purchase of both physical and digital goods and service (e.g.
 * handset, telecom network service). Shopping Cart contain list of cart items,
 * a reference to customer (partyRole) or contact medium in case customer not
 * exist, and the total items price including promotions
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-663: Shopping Cart Management API</li>
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
    defaultImpl = ShoppingCartCreate.class
)
public class ShoppingCartCreate extends ShoppingCartUpdate {

  /**
   * Total amount of the shopping cart, usually of money, that represents the
   * actual price paid by the Customer for cart (considering only "Active" cart
   * items).
   */
  @JsonProperty("cartTotalPrice")
  private List<@Valid CartPrice> cartTotalPrices;

  /**
   * The period for which the shopping cart is valid (e.g. 90 if no activity or 7
   * days if cart is empty).
   */
  private @Valid TimePeriod validFor;
}