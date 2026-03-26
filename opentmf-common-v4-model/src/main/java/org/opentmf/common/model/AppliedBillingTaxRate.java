package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The applied billing tax rate represents taxes applied billing rate it refers
 * to. It is calculated during the billing process.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-678: Customer Bill Management API</li>
 *   <li>TMF-728: Dunning Case Management</li>
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
    defaultImpl = AppliedBillingTaxRate.class
)
public class AppliedBillingTaxRate extends Entity implements IAppliedBillingTaxRate {

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money taxAmount;

  /**
   * A categorization of the tax rate.
   */
  private @SafeText String taxCategory;

  /**
   * Applied rate.
   */
  private BigDecimal taxRate;
}