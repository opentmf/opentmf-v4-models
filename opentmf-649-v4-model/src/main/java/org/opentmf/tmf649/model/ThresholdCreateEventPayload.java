package org.opentmf.tmf649.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

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
public class ThresholdCreateEventPayload implements IThresholdCreateEventPayload {

  /**
   * A threshold base entity containing threshold rules.
   */
  private @Valid Threshold threshold;
}