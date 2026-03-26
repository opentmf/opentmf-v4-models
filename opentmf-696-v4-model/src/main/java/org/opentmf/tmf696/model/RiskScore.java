package org.opentmf.tmf696.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This resource reflects a score for a specific risk.
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
    defaultImpl = RiskScore.class
)
public class RiskScore extends Extensible implements IRiskScore {

  /**
   * Types of risk that can be assessed
   * <br/><p>Recommended values: FraudRisk, BadPaymentRisk, CreditGamingRisk,
   * IDConfidenceRisk, PaymentMethodRisk.
   *
   * @see org.opentmf.tmf696.model.RiskType
   */
  private @SafeText String riskName;

  /**
   * The risk score.
   */
  private BigDecimal score;
}