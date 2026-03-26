package org.opentmf.tmf649.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.general.model.ThresholdRule;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-649: Performance Thresholding Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ThresholdRuleChangeEventPayload implements IThresholdRuleChangeEventPayload {

  /**
   * ThresholdRule A base entity for concrete definition of thresholds.This
   * datatype is abstract.
   */
  private @Valid ThresholdRule thresholdRule;
}