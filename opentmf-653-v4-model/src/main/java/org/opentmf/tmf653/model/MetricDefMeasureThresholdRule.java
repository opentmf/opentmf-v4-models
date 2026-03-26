package org.opentmf.tmf653.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Duration;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A MetricDefMeasureThresholdRule is a rule that defines the condition (raise
 * or clear) to achieve to apply 
 * <br/>consequences when a threshold is crossed or ceased to be crossed. It
 * also defines the severity of the 
 * <br/>raise or clear of the threshold.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-653: Service Test Management API</li>
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
    defaultImpl = MetricDefMeasureThresholdRule.class
)
public class MetricDefMeasureThresholdRule extends Extensible implements IMetricDefMeasureThresholdRule {

  /**
   * An operator that when applied on a value specifies whether the 
   * <br/>value is the same or not. This operator is used to compare with the
   * conformanceTargetExact if used.
   */
  private Boolean conformanceComparatorExact;

  /**
   * An operator that when applied on a value specifies whether a 
   * <br/>threshold is crossed or ceased to be crossed. This operator is used to
   * Service Test Management API REST Specification compare with the
   * conformanceTargetLower if used.
   */
  private @SafeText String conformanceComparatorLower;

  /**
   * An operator that when applied on a value specifies whether a 
   * <br/>threshold is crossed or ceased to be crossed. This operator is used to
   * compare with the conformanceTargetUpper if used.
   */
  private @SafeText String conformanceComparatorUpper;

  /**
   * To cater for values that are not numerical test metrics (e.g. a DSL line can
   * be Synchronised or Unsynchronised. If the latter, the test should result in a
   * rule violation). The allowed value can contain a REGEX expression.
   */
  private @SafeText String conformanceTargetExact;

  /**
   * A value used to determine if the threshold is crossed or ceases 
   * <br/>to be crossed. It represents the lower limit. The value should be less
   * than the conformanceTargetUpper if used. The conformance comparators should
   * also be logically defined so as to not lead to a logically impossible
   * condition.
   */
  private @SafeText String conformanceTargetLower;

  /**
   * A value used to determine if the threshold is crossed or ceases 
   * <br/>to be crossed. It represents the Upper limit. The value should be
   * greater than the conformanceTargetLower if used. The conformance comparators
   * should also be logically defined so as to not lead to a logically impossible
   * condition.
   */
  private @SafeText String conformanceTargetUpper;

  /**
   * A list of consequences (actions, notifications) that will arise if the
   * threshold is crossed.
   */
  @JsonProperty("consequence")
  private List<@Valid MetricDefMeasureConsequence> consequences;

  /**
   * Description for the MetricDefMeasureThresholdRule .
   */
  private @SafeText String description;

  /**
   * Name for the MetricDefMeasureThresholdRule .
   */
  private @SafeText String name;

  /**
   * The number of allowed crossing occurrences in reference to the 
   * <br/>tolerancePeriod without a consequence being initiated.
   */
  private Integer numberOfAllowedCrossing;

  /**
   * A threshold can be generated in different severity levels. A 
   * <br/>crossing for each level may require a different condition and possibly
   * trigger a different consequence.
   */
  private @SafeText String thresholdRuleSeverity;

  /**
   * A time interval in a given unit of time.
   */
  private @Valid Duration tolerancePeriod;
}