package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Identifies the details of the threshold that has been crossed.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-642: Alarm Management API</li>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
 *   <li>TMF-915: AI Management API</li>
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
    defaultImpl = CrossedThresholdInformation.class
)
public class CrossedThresholdInformation extends Extensible implements ICrossedThresholdInformation {

  /**
   * Indicates the threshold crossing direction: up or down.
   */
  private @SafeText String direction;

  /**
   * Indicates the granularity at which the indicator is evaluated for threshold
   * crossing.
   */
  private @SafeText String granularity;

  /**
   * Indicates the name of indicator which crossed the threshold.
   */
  private @SafeText String indicatorName;

  /**
   * Indicates the unit of the measurement of the indicator corresponding to the
   * threshold that has been crossed.
   */
  private @SafeText String indicatorUnit;

  /**
   * Indicates the value of the indicator which crossed the threshold.
   */
  private @SafeText String observedValue;

  private @Valid ThresholdRef threshold;

  /**
   * Indicates further information on the threshold crossing alarm.
   */
  private @SafeText String thresholdCrossingDescription;
}