package org.opentmf.v4.tmf622.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.product.model.BillingAccountRef;
import org.opentmf.v4.product.model.PriceAlteration;
import org.opentmf.v4.product.model.PriceBase;
import org.opentmf.v4.product.model.ProductOfferingPriceRef;

/**
 * An amount, usually of money, that represents the actual price paid by the
 * Customer for this item or this order.
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
    defaultImpl = OrderPrice.class
)
public class OrderPrice extends PriceBase {

  /**
   * A reference to a billing account used for paid the order price charge.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * a structure used to describe a price alteration.
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