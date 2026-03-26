package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A tax item is created for each tax rate and tax type used in the bill.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-678: Customer Bill Management API</li>
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
    defaultImpl = TaxItem.class
)
public class TaxItem extends Entity implements ITaxItem {

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money taxAmount;

  /**
   * Tax category.
   */
  private @SafeText String taxCategory;

  /**
   * Applied rate of the tax.
   */
  private BigDecimal taxRate;
}