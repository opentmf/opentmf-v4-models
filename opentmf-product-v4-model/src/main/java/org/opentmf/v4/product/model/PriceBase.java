package org.opentmf.v4.product.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;

/**
 * An amount, usually of money, that represents the actual price paid by a
 * Customer for a purchase, a rent or a lease of a Product. The price is valid
 * for a defined period of time.
 *
 * <p><br/>
 * <strong>Required:</strong> price, priceType<br/>
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
    defaultImpl = PriceBase.class
)
@Required(fields = {"price", "priceType"})
public class PriceBase extends Extensible {

  /**
   * A narrative that explains in detail the semantics of this product price.
   */
  private @SafeText String description;

  /**
   * A short descriptive name such as "Subscription price".
   */
  private @SafeText String name;

  /**
   * A category that describes the price, such as recurring, discount, allowance,
   * penalty, and so forth.
   */
  private @SafeText String priceType;

  /**
   * Could be month, week...
   */
  private @SafeText String recurringChargePeriod;

  /**
   * Could be minutes, GB...
   */
  private @SafeText String unitOfMeasure;

  private @Valid Price price;
}