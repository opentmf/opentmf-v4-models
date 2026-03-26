package org.opentmf.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;

/**
 * A set of numbers that specifies the lower and upper limits for a
 * ProductOffering that can be procured as part of the related
 * BundledProductOffering. Values can range from 0 to unbounded.
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = BundledProductOfferingOption.class
)
public class BundledProductOfferingOption extends Extensible implements IBundledProductOfferingOption {

  /**
   * Default number of product offerings that should be procured as part of the
   * related BundledProductOffering.
   */
  private Integer numberRelOfferDefault;

  /**
   * lower limit for a product offering that can be procured as part of the
   * related BundledProductOffering.
   */
  private Integer numberRelOfferLowerLimit;

  /**
   * upper limit for a product offering that can be procured as part of the
   * related BundledProductOffering.
   */
  private Integer numberRelOfferUpperLimit;
}