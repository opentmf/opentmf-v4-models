package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Duration;
import org.opentmf.v4.common.model.NamedEntity;
import org.opentmf.v4.common.model.Quantity;
import org.opentmf.v4.common.model.TimePeriod;

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
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = POPAlteration.class
)
@Required(fields = {"price", "priceType"})
public class POPAlteration extends NamedEntity {

  /**
   * A narrative that explains in detail the semantics of this order item price
   * alteration.
   */
  private @SafeText String description;

  /**
   * A category that describes the price such as recurring, one time and usage.
   */
  private @SafeText String priceType;

  /**
   * Priority level for applying this alteration among all the defined alterations
   * on the order item price.
   */
  private Integer priority;

  /**
   * Could be month, week...
   */
  private @SafeText String recurringChargePeriod;

  /**
   * The period for which the productOfferingPriceAlteration is applicable.
   */
  private @Valid Duration applicationDuration;

  private @Valid ProductPriceValue price;

  /**
   * A number and unit representing denominator of an alteration rate. For
   * example, for a data discount rate of $1 per 20 GB usage, the amount of
   * unitOfMeasure will be 20 with units as GB.
   */
  private @Valid Quantity unitOfMeasure;

  /**
   * The period for which this productOfferingPriceAlteration is valid.
   */
  private @Valid TimePeriod validFor;
}