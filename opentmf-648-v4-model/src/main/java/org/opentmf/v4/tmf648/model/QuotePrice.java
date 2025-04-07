package org.opentmf.v4.tmf648.model;

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
 * Description of price and discount awarded.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-648: Quote Management API</li>
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
    defaultImpl = QuotePrice.class
)
public class QuotePrice extends PriceBase {

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