package org.opentmf.tmf653.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A TestMeasure specifies a measure of a specific aspect of a product, service,
 * or resource test, such as lost packets or connectivity status.
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
    defaultImpl = TestMeasure.class
)
public class TestMeasure extends Extensible implements ITestMeasure {

  /**
   * The number of digits of accuracy captured for associated Metrics.
   */
  private BigDecimal accuracy;

  /**
   * The date and time that the metric was captured.
   */
  private OffsetDateTime captureDateTime;

  /**
   * The method used to capture the Metrics (This may be replaced by a set of
   * entities similar to the Performance Monitoring Ref).
   */
  private @SafeText String captureMethod;

  /**
   * Brief description of the metric.
   */
  private @SafeText String metricDescription;

  /**
   * Hyperlink to access a metric for detail information.
   */
  private URI metricHref;

  /**
   * The name of the metric.
   */
  private @SafeText String metricName;

  /**
   * A list of rules that were violated in this test measure.
   */
  @JsonProperty("ruleViolation")
  private List<@Valid MeasureThresholdRuleViolation> ruleViolations;

  /**
   * The unit of measure for the metric values, such as meters, cubic yards,
   * kilograms [ISO 1000].
   */
  private @SafeText String unitOfMeasure;

  /**
   * Describes a given characteristic of an object or entity through a name/value
   * pair.
   */
  private @Valid Characteristic value;
}