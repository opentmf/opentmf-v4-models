package org.opentmf.tmf696.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ProductOrderRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * This is a task resource allowing assessment of the risks associated with a
 * product order - presumably submitted by a party role and containing one or
 * more product offerings.
 *
 * <p><br/>
 * <strong>Required:</strong> productOrder<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-696: Risk Management API</li>
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
    defaultImpl = ProductOrderRiskAssessment.class
)
@Required(fields = {"productOrder"})
public class ProductOrderRiskAssessment extends RiskAssessment implements IProductOrderRiskAssessment {

  /**
   * ProductOrder (ProductOrder) .The product order which the recommendation is
   * related with.
   */
  private @Valid ProductOrderRef productOrder;
}