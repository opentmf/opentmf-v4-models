package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>CartPrice (663)</li>
 *   <li>OrderPrice (622)</li>
 *   <li>QuotePrice (648)</li>
 *   <li>WorkPrice (713, 714)</li>
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
    defaultImpl = PriceBase.class
)
public abstract class PriceBase extends Extensible implements IPriceBase {

  /**
   * A narrative that explains in detail the semantics of this order item price.
   */
  private @SafeText String description;

  /**
   * A short descriptive name such as "Subscription price".
   */
  private @SafeText String name;

  /**
   * List of: Is an amount, usually of money, that modifies the price charged for
   * an order item.
   */
  @JsonProperty("priceAlteration")
  private List<@Valid PriceAlteration> priceAlterations;

  /**
   * A category that describes the price, such as recurring, discount, allowance,
   * penalty, and so forth.
   */
  private @SafeText String priceType;

  /**
   * ProductPriceOffering reference. An amount, usually of money, that is asked
   * for or allowed when a ProductOffering is bought, rented, or leased.
   */
  private @Valid ProductOfferingPriceRef productOfferingPrice;

  /**
   * Could be month, week...
   */
  private @SafeText String recurringChargePeriod;
}