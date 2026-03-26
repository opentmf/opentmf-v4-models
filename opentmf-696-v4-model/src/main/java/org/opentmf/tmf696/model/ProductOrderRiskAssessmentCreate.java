package org.opentmf.tmf696.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ProductOrderRef;
import org.opentmf.common.model.RelatedPlace;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This is a task resource allowing assessment of the risks associated with a
 * product order - presumably submitted by a party role and containing one or
 * more product offerings
 * <br/>Skipped properties: id,href.
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
    defaultImpl = ProductOrderRiskAssessmentCreate.class
)
@Required(fields = {"productOrder"})
public class ProductOrderRiskAssessmentCreate extends Extensible implements IProductOrderRiskAssessmentCreate {

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
   * ProductOrder (ProductOrder) .The product order which the recommendation is
   * related with.
   */
  private @Valid ProductOrderRef productOrder;

  /**
   * This resource reflects the risk assessment.
   */
  private @Valid RiskAssessmentResult riskAssessmentResult;

  /**
   * The status of the risk assessment, such as Succeeded, In Progress, Failed,
   * output from the task.
   */
  private @SafeText String status;
}