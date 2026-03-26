package org.opentmf.tmf915.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A counter/KPI to be used by the threshold rule.
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
    defaultImpl = Measurement.class
)
public class Measurement extends NamedEntity implements IMeasurement {

  /**
   * This attribute indicates different forms in which the measurement data can be
   * captured (please see details below).
   */
  private @SafeText String collectionType;

  /**
   * A description of the measurement.
   */
  private @SafeText String description;

  /**
   * A formula that is used to calculate a measurement (a string).
   */
  private @SafeText String measurementFormula;

  /**
   * A category of the measurement (different SDOs may be using different
   * categories).
   */
  private @SafeText String measurementType;

  /**
   * The unit of the measurement (e.g. second, bytes, Celsius, etc.).
   */
  private @SafeText String measurementUnit;
}