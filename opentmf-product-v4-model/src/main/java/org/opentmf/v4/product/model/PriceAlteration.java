package org.opentmf.v4.product.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Is an amount, usually of money, that modifies the price charged for an order
 * item.
 *
 * <p><br/>
 * <strong>Required:</strong> price, priceType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-648: Quote Management API</li>
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
    defaultImpl = PriceAlteration.class
)
@Required(fields = {"price", "priceType"})
public class PriceAlteration extends PriceBase {

  /**
   * Duration during which the alteration applies on the order item price (for
   * instance 2 months free of charge for the recurring charge).
   */
  private Integer applicationDuration;

  /**
   * Priority level for applying this alteration among all the defined alterations
   * on the order item price.
   */
  private Integer priority;

  private @Valid ProductOfferingPriceRef productOfferingPrice;
}