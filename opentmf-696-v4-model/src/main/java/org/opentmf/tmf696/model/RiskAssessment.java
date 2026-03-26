package org.opentmf.tmf696.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.RelatedPlace;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This is a generalized task resource allowing assessment of risks - it is
 * expected that the resource will be specialized to reflect specific risks,
 * such as risks associated with a party, or with an order, etc.
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
    defaultImpl = RiskAssessment.class
)
public class RiskAssessment extends Entity implements IRiskAssessment {

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
   * The status of the risk assessment, such as Succeeded, In Progress, Failed,
   * output from the task.
   */
  private @SafeText String status;
}