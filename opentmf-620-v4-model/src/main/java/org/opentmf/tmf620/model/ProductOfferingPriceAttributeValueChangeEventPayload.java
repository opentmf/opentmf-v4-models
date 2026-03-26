package org.opentmf.tmf620.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class ProductOfferingPriceAttributeValueChangeEventPayload implements IProductOfferingPriceAttributeValueChangeEventPayload {

  /**
   * Is based on both the basic cost to develop and produce products and the
   * enterprises policy on revenue targets. This price may be further revised
   * through discounting (a Product Offering Price that reflects an alteration).
   * The price, applied for a productOffering may also be influenced by the
   * productOfferingTerm, the customer selected, eg: a productOffering can be
   * offered with multiple terms, like commitment periods for the contract. The
   * price may be influenced by this productOfferingTerm. A productOffering may be
   * cheaper with a 24 month commitment than with a 12 month commitment.
   */
  private @Valid ProductOfferingPrice productOfferingPrice;
}