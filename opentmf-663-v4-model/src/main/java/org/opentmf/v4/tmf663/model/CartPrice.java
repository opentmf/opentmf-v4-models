package org.opentmf.v4.tmf663.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.product.model.PriceAlteration;
import org.opentmf.v4.product.model.PriceBase;
import org.opentmf.v4.product.model.ProductOfferingPriceRef;

/**
 * An amount, usually of money, that represents the actual price paid by the
 * customer for this item. May represent the total price of the shopping cart or
 * the total of the cart item depending on the relation.
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
    defaultImpl = CartPrice.class
)
public class CartPrice extends PriceBase {

  /**
   * List of: Is an amount, usually of money, that modifies the price charged for
   * an order item.
   */
  @JsonProperty("priceAlteration")
  private List<@Valid PriceAlteration> priceAlterations;

  /**
   * An amount, usually of money, that is asked for or allowed when a
   * ProductOffering is bought, rented, or leased. The price is valid for a
   * defined period of time.
   */
  private @Valid ProductOfferingPriceRef productOfferingPrice;
}