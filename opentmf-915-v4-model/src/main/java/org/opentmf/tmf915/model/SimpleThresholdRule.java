package org.opentmf.tmf915.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.general.model.Consequence;
import org.opentmf.general.model.PerformanceAlarmSpecification;

/**
 * A threshold rule that is based on explicit definition of attributes that
 * represent a Boolean expression.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = SimpleThresholdRule.class
)
public class SimpleThresholdRule extends NamedEntity implements ISimpleThresholdRule {

  /**
   * An operator that when applied on a value (of conformanceTargetLower)
   * specifies whether a Performance threshold rule is crossed or ceased to be
   * crossed.
   */
  private Integer conformanceComparatorLower;

  /**
   * An operator that when applied on a value (of conformanceTargetUpper)
   * specifies whether a Performance threshold rule is crossed or ceased to be
   * crossed.
   */
  private @SafeText String conformanceComparatorUpper;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod conformancePeriod;

  /**
   * A value used to determine if the Performance threshold is crossed or ceased
   * to be crossed, serving as an lower value.
   */
  private Integer conformanceTargetLower;

  /**
   * A value used to determine if the Performance threshold is crossed or ceased
   * to be crossed, serving as an upper value.
   */
  private Integer conformanceTargetUpper;

  /**
   * A threshold crossing or a threshold ceased to be crossing results in a
   * Performance consequence.
   */
  @JsonProperty("consequence")
  private List<@Valid Consequence> consequences;

  /**
   * The number of times an objective can remain un-updated in reference to the
   * conformancePeriod without a Performance threshold Consequence being
   * initiated.
   */
  private Integer gracePeriods;

  /**
   * A counter/KPI to be used by the threshold rule.
   */
  private @Valid Measurement measurement;

  /**
   * A specific description of the threshold crossing (intended to be populated e
   * under the alarm under CrossedThreshold structure).
   */
  private @SafeText String perfAlarmSpecThresholdCrossingDescription;

  /**
   * The specification of how to populate the alarm fields when generating a
   * threshold crossing alarm.
   */
  private @Valid PerformanceAlarmSpecification performanceAlarmSpecification;

  /**
   * A concrete threshold may have two possible values: \"Raise\" - a threshold
   * was crossed or \"Clear\" - a threshold ceased crossing.
   */
  private @SafeText String thresholdRuleCondition;

  /**
   * A word, term, or phrase by which a Performance threshold rule is known and
   * distinguished from other threshold rules.
   */
  private @SafeText String thresholdRuleName;

  /**
   * A threshold can be generated in different severity levels. A crossing for
   * each level may require a different condition and possibly trigger a different
   * consequence. The supported severity levels are equivalent to the possible
   * severity level of alarms.
   */
  private @SafeText String thresholdRuleSeverity;

  /**
   * A percent that is used to specify when a warning should be used that
   * indicates a Performance threshold is in danger of not being met.
   */
  private Integer thresholdTarget;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod tolerancePeriod;
}