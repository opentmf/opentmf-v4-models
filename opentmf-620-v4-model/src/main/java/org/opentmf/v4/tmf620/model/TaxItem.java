package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Entity;
import org.opentmf.v4.common.model.Money;

/**
 * A tax item is created for each tax rate and tax type used in the bill.
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
    defaultImpl = TaxItem.class
)
public class TaxItem extends Entity {

  /**
   * Tax category.
   */
  private @SafeText String taxCategory;

  /**
   * Applied rate of the tax.
   */
  private BigDecimal taxRate;

  /**
   * Amount of tax expressed in the given currency.
   */
  private @Valid Money taxAmount;
}