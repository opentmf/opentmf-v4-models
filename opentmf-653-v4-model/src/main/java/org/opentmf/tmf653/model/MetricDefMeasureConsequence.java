package org.opentmf.tmf653.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A MetricDefMeasureConsequence defines the action (prescribed action or
 * notification) to take when a 
 * <br/>MetricDefMeasureThresholdRule is crossed.
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
    defaultImpl = MetricDefMeasureConsequence.class
)
public class MetricDefMeasureConsequence extends Extensible implements IMetricDefMeasureConsequence {

  /**
   * A narrative that explains in detail what the consequence is.
   */
  private @SafeText String description;

  /**
   * A word, term, or phrase by which a 
   * <br/>MetricDefMeasureConsequence is known and distinguished from other
   * MetricDefMeasureConsequences.
   */
  private @SafeText String name;

  /**
   * Recommended remedy for a violated threshold. This could be 
   * <br/>the hyperlink to the action.
   */
  private @SafeText String prescribeAction;

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

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}