package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * A Consequence can be applied as a result of a threshold crossing or a
 * threshold ceasing to be crossed.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-649: Performance Thresholding Management API</li>
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
    defaultImpl = PerformanceConsequence.class
)
public class PerformanceConsequence extends Consequence implements IPerformanceConsequence {

  /**
   * The specification of how to populate the alarm fields when generating a
   * threshold crossing alarm.
   */
  private @Valid PerformanceAlarmSpecification alarmSpecification;
}