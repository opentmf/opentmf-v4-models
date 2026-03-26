package org.opentmf.tmf696.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;

/**
 * This resource reflects the risk assessment.
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
    defaultImpl = RiskAssessmentResult.class
)
public class RiskAssessmentResult extends Extensible implements IRiskAssessmentResult {

  /**
   * An overall assessment of the risk, composed from the individual scores.
   */
  private BigDecimal overallScore;

  /**
   * Additional characteristics for which the risk might be assessed, optional
   * input to the task.
   */
  @JsonProperty("score")
  private List<@Valid RiskScore> scores;
}