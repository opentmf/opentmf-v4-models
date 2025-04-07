package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * A type of ProductOffering that belongs to a grouping of ProductOfferings made
 * available to the market. It inherits of all attributes of ProductOffering.
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
    defaultImpl = BundledProductOffering.class
)
public class BundledProductOffering extends BundledProductSpecification {

  /**
   * A set of numbers that specifies the lower and upper limits for a
   * ProductOffering that can be procured as part of the related
   * BundledProductOffering. Values can range from 0 to unbounded.
   */
  private @Valid BundledProductOfferingOption bundledProductOfferingOption;
}