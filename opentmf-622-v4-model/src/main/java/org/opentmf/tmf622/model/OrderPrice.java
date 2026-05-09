package org.opentmf.tmf622.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.BillingAccountRef;
import org.opentmf.common.model.Price;
import org.opentmf.common.model.PriceBase;
import org.opentmf.commons.validation.constraints.SafeText;

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
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = OrderPrice.class
)
public class OrderPrice extends PriceBase implements IOrderPrice {

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * Provides all amounts (tax included, duty free, tax rate), used currency and
   * percentage to apply for Price Alteration.
   */
  private @Valid Price price;

  /**
   * Could be minutes, GB...
   */
  private @SafeText String unitOfMeasure;
}