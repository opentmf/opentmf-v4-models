package org.opentmf.tmf653.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Duration;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A TestMeasureDefinition specifies a measure of a specific aspect of a
 * product, service, or resource test, such as lost packets or connectivity
 * status.
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
    defaultImpl = TestMeasureDefinition.class
)
public class TestMeasureDefinition extends Extensible implements ITestMeasureDefinition {

  /**
   * The frequency of capture for the metric. Note: This may be replaced by a set
   * of entities similar to the Performance Monitoring.
   */
  private @SafeText String captureFrequency;

  /**
   * The method used to capture the Metric. Note: This may be replaced by a set of
   * entities similar to the Performance Monitoring.
   */
  private @SafeText String captureMethod;

  /**
   * A time interval in a given unit of time.
   */
  private @Valid Duration capturePeriod;

  /**
   * Brief description of the metric.
   */
  private @SafeText String metricDescription;

  /**
   * Hyperlink to access a metric for detail information.
   */
  private URI metricHref;

  /**
   * The name of a metric that in the test measure.
   */
  private @SafeText String metricName;

  /**
   * The name of the TestMeasureDefinition.
   */
  private @SafeText String name;

  /**
   * The rule(s) associated with the measure threshold.
   */
  @JsonProperty("thresholdRule")
  private List<@Valid MetricDefMeasureThresholdRule> thresholdRules;

  /**
   * Name of a service test specification.
   */
  private @SafeText String unitOfMeasure;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * A kind of value that the Metric value can take on, such as numeric, text, and
   * so forth.
   */
  private @SafeText String valueType;
}