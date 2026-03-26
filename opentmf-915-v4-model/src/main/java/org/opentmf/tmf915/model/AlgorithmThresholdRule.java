package org.opentmf.tmf915.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.general.model.Consequence;
import org.opentmf.general.model.PerformanceAlarmSpecification;

/**
 * A threshold rule that is a reference to an algorithm.
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
    defaultImpl = AlgorithmThresholdRule.class
)
public class AlgorithmThresholdRule extends NamedEntity implements IAlgorithmThresholdRule {

  @JsonProperty("algorithmParams")
  private List<@Valid AlgorithmParams> algorithmParamses;

  private @SafeText String algorithmRef;

  /**
   * A threshold crossing or a threshold ceased to be crossing results in a
   * Performance consequence.
   */
  @JsonProperty("consequence")
  private List<@Valid Consequence> consequences;

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
}