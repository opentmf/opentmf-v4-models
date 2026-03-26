package org.opentmf.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CharacteristicRelationship;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Provides the value of a given characteristic.
 *
 * <p><br/>
 * <strong>Required:</strong> name, value<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-635: Usage Management API</li>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = UsageCharacteristic.class
)
@Required(fields = {"name", "value"})
public class UsageCharacteristic extends Extensible implements IUsageCharacteristic {

  /**
   * List of: Another Characteristic that is related to the current
   * Characteristic;.
   */
  @JsonProperty("characteristicRelationship")
  private List<@Valid CharacteristicRelationship> characteristicRelationships;

  /**
   * Unique identifier of the characteristic.
   */
  @SafeId
  @Size(max = 100)
  private String id;

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