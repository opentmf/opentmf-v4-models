package org.opentmf.tmf696.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedPlace;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.customer.model.ShoppingCartRef;

/**
 * This is a task resource allowing assessment of the risks associated with a
 * shopping cart - presumably created by a party role and containing one or more
 * product offerings
 * <br/>Skipped properties: id,href.
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
    defaultImpl = ShoppingCartRiskAssessmentCreate.class
)
@Required(fields = {"shoppingCart"})
public class ShoppingCartRiskAssessmentCreate extends Extensible implements IShoppingCartRiskAssessmentCreate {

  /**
   * Additional characteristics for which the risk might be assessed, optional
   * input to the task.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * A Place and an associated role as installation adress, delivery address,
   * etc....
   */
  private @Valid RelatedPlace place;

  /**
   * This resource reflects the risk assessment.
   */
  private @Valid RiskAssessmentResult riskAssessmentResult;

  /**
   * ShoppingCart (ShoppingCartRef) . The shopping cart which the recommendation
   * is related with.
   */
  private @Valid ShoppingCartRef shoppingCart;

  /**
   * The status of the risk assessment, such as Succeeded, In Progress, Failed,
   * output from the task.
   */
  private @SafeText String status;
}