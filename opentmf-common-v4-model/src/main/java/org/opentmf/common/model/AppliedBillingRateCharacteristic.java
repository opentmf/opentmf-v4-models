package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An applied billing rate has dynamic characteristics according to the its type
 * (characteristics are based on the service type, line of business or on others
 * parameters).
 *
 * <p><br/>
 * <strong>Required:</strong> name, value<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-678: Customer Bill Management API</li>
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
    defaultImpl = AppliedBillingRateCharacteristic.class
)
@Required(fields = {"name", "value"})
public class AppliedBillingRateCharacteristic extends Extensible implements IAppliedBillingRateCharacteristic {

  /**
   * Name of the characteristic.
   */
  private @SafeText String name;

  private Object value;

  /**
   * Data type of the value of the characteristic.
   */
  private @SafeText String valueType;
}