package org.opentmf.tmf696.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.customer.model.ShoppingCartRef;

/**
 * This is a task resource allowing assessment of the risks associated with a
 * shopping cart - presumably created by a party role and containing one or more
 * product offerings.
 *
 * <p><br/>
 * <strong>Required:</strong> shoppingCart<br/>
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
    defaultImpl = ShoppingCartRiskAssessment.class
)
@Required(fields = {"shoppingCart"})
public class ShoppingCartRiskAssessment extends RiskAssessment implements IShoppingCartRiskAssessment {

  /**
   * ShoppingCart (ShoppingCartRef) . The shopping cart which the recommendation
   * is related with.
   */
  private @Valid ShoppingCartRef shoppingCart;
}