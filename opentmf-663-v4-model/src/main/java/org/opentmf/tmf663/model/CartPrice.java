package org.opentmf.tmf663.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CartPriceBase;
import org.opentmf.common.model.Price;
import org.opentmf.common.model.PriceAlteration;
import org.opentmf.commons.validation.constraints.SafeText;

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
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = CartPrice.class
)
public class CartPrice extends CartPriceBase implements ICartPrice {

  /**
   * Provides all amounts (tax included, duty free, tax rate), used currency and
   * percentage to apply for Price Alteration.
   */
  private @Valid Price price;

  /**
   * List of: Is an amount, usually of money, that modifies the price charged for
   * an order item.
   */
  @JsonProperty("priceAlteration")
  private List<@Valid PriceAlteration> priceAlterations;

  /**
   * Could be minutes, GB...
   */
  private @SafeText String unitOfMeasure;
}