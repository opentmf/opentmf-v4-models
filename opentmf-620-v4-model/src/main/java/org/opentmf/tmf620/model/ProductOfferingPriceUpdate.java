package org.opentmf.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ConstraintRef;
import org.opentmf.common.model.Money;
import org.opentmf.common.model.PlaceRef;
import org.opentmf.common.model.ProductOfferingUpdateBase;
import org.opentmf.common.model.Quantity;
import org.opentmf.common.model.TaxItem;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Is based on both the basic cost to develop and produce products and the
 * enterprises policy on revenue targets. This price may be further revised
 * through discounting (a Product Offering Price that reflects an alteration).
 * The price, applied for a productOffering may also be influenced by the
 * productOfferingTerm, the customer selected, eg: a productOffering can be
 * offered with multiple terms, like commitment periods for the contract. The
 * price may be influenced by this productOfferingTerm. A productOffering may be
 * cheaper with a 24 month commitment than with a 12 month commitment.
 * <br/>Skipped properties: id,href,lastUpdate,{@literal @}type,{@literal @}baseType.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ProductOfferingPriceUpdate extends ProductOfferingUpdateBase implements IProductOfferingPriceUpdate {

  /**
   * hyperlink reference to the schema describing this resource.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * this object represents a bundle relationship from a bundle product offering
   * price (parent) to a simple product offering price (child). A simple product
   * offering price may participate in more than one bundle relationship.
   */
  @JsonProperty("bundledPopRelationship")
  private List<@Valid BundledProductOfferingPriceRelationship> bundledPopRelationships;

  /**
   * The Constraint resource represents a policy/rule applied to
   * ProductOfferingPrice.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  /**
   * Percentage to apply if this Product Offering Price is an Alteration (such as
   * a Discount).
   */
  private BigDecimal percentage;

  /**
   * Place defines the places where the products are sold or delivered.
   */
  @JsonProperty("place")
  private List<@Valid PlaceRef> places;

  /**
   * Product Offering Prices related to this Product Offering Price, for example a
   * price alteration such as allowance or discount.
   */
  @JsonProperty("popRelationship")
  private List<@Valid ProductOfferingPriceRelationship> popRelationships;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money price;

  /**
   * A category that describes the price, such as recurring, discount, allowance,
   * penalty, and so forth.
   */
  private @SafeText String priceType;

  /**
   * The PricingLogicAlgorithm entity represents an instantiation of an interface
   * specification to external rating function (without a modeled behavior in
   * SID). Some of the parameters of the interface definition may be already set
   * (such as price per unit) and some may be gathered during the rating process
   * from the event (such as call duration) or from ProductCharacteristicValues
   * (such as assigned bandwidth).
   */
  @JsonProperty("pricingLogicAlgorithm")
  private List<@Valid PricingLogicAlgorithm> pricingLogicAlgorithms;

  /**
   * A use of the ProductSpecificationCharacteristicValue by a
   * ProductOfferingPrice to which additional properties (attributes) apply or
   * override the properties of similar properties contained in
   * ProductSpecificationCharacteristicValue. It should be noted that
   * characteristics which their value(s) addressed by this object must exist in
   * corresponding product specification. The available characteristic values for
   * a ProductSpecificationCharacteristic in a Product specification can be
   * modified at the ProductOffering and ProductOfferingPrice level. The list of
   * values in ProductSpecificationCharacteristicValueUse is a strict subset of
   * the list of values as defined in the corresponding product specification
   * characteristics.
   */
  @JsonProperty("prodSpecCharValueUse")
  private List<@Valid ProductSpecificationCharacteristicValueUse> prodSpecCharValueUses;

  /**
   * A list of conditions under which a ProductOfferingPrice is made available to
   * Customers. For instance, a Product Offering Price can be offered with
   * multiple commitment periods.
   */
  @JsonProperty("productOfferingTerm")
  private List<@Valid ProductOfferingTerm> productOfferingTerms;

  /**
   * the period of the recurring charge: 1, 2, ... .It sets to zero if it is not
   * applicable.
   */
  private Integer recurringChargePeriodLength;

  /**
   * The period to repeat the application of the price
   * <br/>Could be month, week...
   */
  private @SafeText String recurringChargePeriodType;

  /**
   * An amount of money levied on the price of a Product by a legislative body.
   */
  @JsonProperty("tax")
  private List<@Valid TaxItem> taxes;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity unitOfMeasure;
}