package org.opentmf.general.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The specification of how to populate the alarm fields when generating a
 * threshold crossing alarm.
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
public class PerformanceAlarmSpecification implements IPerformanceAlarmSpecification {

  private @SafeText String perfAlarmSpecAdditionalText;

  private @SafeText String perfAlarmSpecAlarmType;

  private @SafeText String perfAlarmSpecProbableCause;

  /**
   * This datatype lists the possible severities that can be allocated to a Alarm.
   * The values are consistent with ITU-T Recommendation X.733. This specification
   * does not recommend the use of indeterminate.
   * <br/><p>Recommended values: CRITICAL, MAJOR, MINOR, WARNING, INDETERMINATE,
   * CLEARED.
   *
   * @see org.opentmf.general.model.PerceivedSeverity
   */
  private @SafeText String perfAlarmSpecSeverity;

  private @SafeText String perfAlarmSpecSpecificProblem;

  private @SafeText String perfAlarmThresholdCrossingDescription;

  /**
   * A Consequence can be applied as a result of a threshold crossing or a
   * threshold ceasing to be crossed.
   */
  private @Valid PerformanceConsequence performanceConsequence;
}