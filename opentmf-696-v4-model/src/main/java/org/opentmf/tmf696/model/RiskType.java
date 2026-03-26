package org.opentmf.tmf696.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Types of risk that can be assessed.
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
public enum RiskType {

  FRAUD_RISK("FraudRisk"),
  BAD_PAYMENT_RISK("BadPaymentRisk"),
  CREDIT_GAMING_RISK("CreditGamingRisk"),
  IDCONFIDENCE_RISK("IDConfidenceRisk"),
  PAYMENT_METHOD_RISK("PaymentMethodRisk");

  private final String value;

  RiskType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, RiskType> REVERSE_MAP = new HashMap<>();

  static {
    for (RiskType riskType : values()) {
      REVERSE_MAP.put(riskType.getValue(), riskType);
    }
  }

  @JsonCreator
  public static RiskType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
