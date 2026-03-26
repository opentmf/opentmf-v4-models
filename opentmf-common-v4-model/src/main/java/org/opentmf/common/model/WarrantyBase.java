package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 5 model classes.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-640: Service Activation Management API</li>
 *   <li>TMF-715: Warranty Management</li>
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
    defaultImpl = WarrantyBase.class
)
public abstract class WarrantyBase extends Extensible implements IWarrantyBase {

  /**
   * Free-text description of the service.
   */
  private @SafeText String description;

  /**
   * If true, the service is a ServiceBundle which regroup a service hierarchy. If
   * false, the service is a 'atomic' service (hierarchy leaf).
   */
  private Boolean isBundle;

  /**
   * Name of the service.
   */
  private @SafeText String name;

  /**
   * A list of notes made on this service.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Valid values for the lifecycle state of the service
   * <br/><p>Recommended values: feasibilityChecked, designed, reserved, inactive,
   * active, terminated.
   *
   * @see org.opentmf.common.model.ServiceStateType
   */
  private @SafeText String state;
}