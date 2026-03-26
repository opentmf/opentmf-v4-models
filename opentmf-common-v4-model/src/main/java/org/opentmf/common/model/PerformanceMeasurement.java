package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A counter/KPI to be used by the threshold rule.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-649: Performance Thresholding Management API</li>
 *   <li>TMF-common: common</li>
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
    defaultImpl = PerformanceMeasurement.class
)
public class PerformanceMeasurement extends Entity implements IPerformanceMeasurement {

  /**
   * A free-text description of the performance measurement.
   */
  private @SafeText String description;

  /**
   * A category of the measurement (different SDOs may be using different
   * categories).
   */
  private @SafeText String indicatorCategory;

  /**
   * A word, term, or phrase by which a measurement is known and distinguished
   * from other performance measurements.
   */
  private @SafeText String indicatorName;

  /**
   * This attribute indicates different forms in which the measurement data can be
   * captured (please see details below).
   */
  private @SafeText String indicatorType;

  /**
   * The unit of the measurement (e.g. second, bytes, Celsius, etc.).
   */
  private @SafeText String indicatorUnit;

  private @Valid MeasurementCollectionJobRef measurementCollectionJob;

  /**
   * The measurement value.
   */
  private @SafeText String observedValue;

  /**
   * PerformanceIndicatorSpecification reference: A
   * PerformanceIndicatorSpecification is a detailed description of a tangible or
   * intangible object made available externally in the form of a
   * PerformanceIndicatorSpecification to customers or other parties playing a
   * party role.
   */
  private @Valid PerformanceIndicatorSpecificationRef performanceIndicatorSpecification;

  private @Valid ResourceRef reportingSystem;

  private @Valid ResourceRef sourceSystem;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}