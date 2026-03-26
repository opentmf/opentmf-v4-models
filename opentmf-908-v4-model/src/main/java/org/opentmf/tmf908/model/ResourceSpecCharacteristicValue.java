package org.opentmf.tmf908.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A ResourceSpecCharacteristicValue object is used to define a set of
 * attributes, each of which can be assigned to a corresponding set of
 * attributes in a ResourceSpecCharacteristic object. The values of the
 * attributes in the ResourceSpecCharacteristicValue object describe the values
 * of the attributes that a corresponding ResourceSpecCharacteristic object can
 * take on.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
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
    defaultImpl = ResourceSpecCharacteristicValue.class
)
public class ResourceSpecCharacteristicValue extends Extensible implements IResourceSpecCharacteristicValue {

  /**
   * Indicates if the value is the default value for a characteristic.
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
   * A length, surface, volume, dry measure, liquid measure, money, weight, time,
   * and the like. In general, a determinate quantity or magnitude of the kind
   * designated, taken as a standard of comparison for others of the same kind, in
   * assigning to them numerical values, as 1 foot, 1 yard, 1 mile, 1 square foot.
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
   * A kind of value that the characteristic can take on, such as numeric, text,
   * and so forth.
   */
  private @SafeText String valueType;
}