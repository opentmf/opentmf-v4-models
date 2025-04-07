package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.ConstraintRef;
import org.opentmf.v4.common.model.Quantity;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * This is representing a product offering price (charge) based on both the
 * basic cost to develop and produce products and the enterprises policy on
 * revenue targets. This price may be further revised through discounting (a
 * Product Offering Price that reflects an alteration).
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
    defaultImpl = POPCharge.class
)
public class POPCharge extends BundledProductSpecification {

  /**
   * Description of the productOfferingPrice.
   */
  private @SafeText String description;

  /**
   * the last update time of this ProductOfferingPrice.
   */
  private OffsetDateTime lastUpdate;

  /**
   * A category that describes the price charge, such as recurring, penalty, One
   * time fee and so forth.
   */
  private @SafeText String priceType;

  /**
   * The period type to repeat the application of the price
   * <br/>Could be month, week...
   */
  private @SafeText String recurringChargePeriod;

  /**
   * the period of the recurring charge: 1, 2, ... .It sets to zero if it is not
   * applicable.
   */
  private Integer recurringChargePeriodLength;

  /**
   * ProductOffering version.
   */
  private @SafeText String version;

  /**
   * The Constraint resource represents a policy/rule applied to
   * ProductOfferingPrice.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  private @Valid ProductPriceValue price;

  /**
   * List of: Is an amount, usually of money, that modifies the price charged for
   * an order item.
   */
  @JsonProperty("priceAlteration")
  private List<@Valid POPAlteration> priceAlterations;

  /**
   * A number and unit representing denominator of a rate. For example, for a data
   * charge rate of $2 per 5 GB usage, the amount of unitOfMeasure will be 5 with
   * units as GB.
   */
  private @Valid Quantity unitOfMeasure;

  /**
   * The period for which the productOfferingPrice is valid.
   */
  private @Valid TimePeriod validFor;
}