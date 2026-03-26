package org.opentmf.tmf653.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An Applied Consequence defines the action (prescribed action or notification)
 * to take when a 
 * <br/>MeasureThresholdRuleViolation occurs.
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
    defaultImpl = AppliedConsequence.class
)
public class AppliedConsequence extends Extensible implements IAppliedConsequence {

  /**
   * The action for a violated threshold. This could be a hyperlink to 
   * <br/>the action.
   */
  private @SafeText String appliedAction;

  /**
   * A narrative that explains in detail what the consequence is.
   */
  private @SafeText String description;

  /**
   * A word, term, or phrase by which Consequence is known and 
   * <br/>distinguished from other MetricDefMeasureConsequences.
   */
  private @SafeText String name;

  /**
   * An indicator used to specify that a consequence should cease 
   * <br/>being applied if a value is in the same range as the previous value or
   * continue being applied if a value is in the same range as the previous value.
   * <br/>If the repeatAction is True, if the consequence is always applied as
   * soon as the MetricMeasure value is in the range of values and if the
   * repeatAction is False, the consequence is applied only if the previous
   * MetricMeasure value was not in the same range.
   */
  private Boolean repeatAction;
}