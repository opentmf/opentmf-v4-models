package org.opentmf.tmf644.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A number or text that can be assigned to a SpecificationCharacteristic.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-644: Privacy Management API</li>
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
    defaultImpl = SpecificationCharacteristicValue.class
)
public class SpecificationCharacteristicValue extends Entity implements ISpecificationCharacteristicValue {

  /**
   * If true, the Boolean Indicates if the value is the default value for a
   * characteristic.
   */
  private Boolean isDefault;

  /**
   * An indicator that specifies the inclusion or exclusion of the valueFrom and
   * valueTo attributes. If applicable, possible values are "open", "closed",
   * "closedBottom" and "closedTop".
   */
  private @SafeText String rangeInterval;

  /**
   * A regular expression constraint for given value.
   */
  private @SafeText String regex;

  /**
   * unit of measure for the valueCould be minutes, GB, etc.
   */
  private @SafeText String unitOfMeasure;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  private Object value;

  /**
   * The low range value that a characteristic can take on.
   */
  private Integer valueFrom;

  /**
   * The upper range value that a characteristic can take on.
   */
  private Integer valueTo;

  /**
   * A kind of value that the characteristic value can take on, such as numeric,
   * text and so forth.
   */
  private @SafeText String valueType;
}