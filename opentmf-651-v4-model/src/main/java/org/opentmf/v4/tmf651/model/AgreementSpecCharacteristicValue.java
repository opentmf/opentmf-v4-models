package org.opentmf.v4.tmf651.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Entity;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * A number or text that can be assigned to an agreement specification
 * characteristic.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = AgreementSpecCharacteristicValue.class
)
public class AgreementSpecCharacteristicValue extends Entity {

  /**
   * Indicates if the value is the default value for a characteristic.
   */
  @JsonProperty("default")
  private Boolean defaultValue;

  /**
   * Unit of measure for the characteristic, such as minutes, gigabytes (GB) and
   * so on.
   */
  private @SafeText String unitOfMeasure;

  /**
   * The low range value that a characteristic can take on.
   */
  private @SafeText String valueFrom;

  /**
   * The upper range value that a characteristic can take on.
   */
  private @SafeText String valueTo;

  /**
   * A kind of value that the characteristic can take on, such as numeric, text,
   * and so forth.
   */
  private @SafeText String valueType;

  /**
   * The period of time for which a value is applicable.
   */
  private @Valid TimePeriod validFor;

  /**
   * A discrete value that the characteristic can take on.
   */
  private Object value;
}