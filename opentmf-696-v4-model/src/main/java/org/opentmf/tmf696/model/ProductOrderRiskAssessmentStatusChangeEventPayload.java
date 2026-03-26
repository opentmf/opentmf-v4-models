package org.opentmf.tmf696.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class ProductOrderRiskAssessmentStatusChangeEventPayload implements IProductOrderRiskAssessmentStatusChangeEventPayload {

  /**
   * This is a task resource allowing assessment of the risks associated with a
   * product order - presumably submitted by a party role and containing one or
   * more product offerings.
   */
  private @Valid ProductOrderRiskAssessment productOrderRiskAssessment;
}