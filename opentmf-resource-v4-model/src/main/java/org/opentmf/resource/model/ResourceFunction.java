package org.opentmf.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A ResourceFunction is a behavior to transform inputs of any nature into
 * outputs of any nature independently from the way it is provided.
 *
 * <p><br/>
 * <strong>Required:</strong> href, id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
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
    defaultImpl = ResourceFunction.class
)
@Required(fields = {"href", "id"})
public class ResourceFunction extends LogicalResource implements IResourceFunction {

  /**
   * List of the kinds of auto-modifications that are applied to a given network
   * service e.g. what can be scaled.
   */
  @JsonProperty("autoModification")
  private List<@Valid Characteristic> autoModifications;

  /**
   * External connection points of the resource function. These are the service
   * access points (SAP) where inputs and outputs of the function are available.
   */
  @JsonProperty("connectionPoint")
  private List<@Valid ConnectionPointRef> connectionPoints;

  /**
   * Internal connectivity of contained resource functions.
   */
  @JsonProperty("connectivity")
  private List<@Valid ResourceGraph> connectivities;

  /**
   * A type of the Resource Function as specified by the provider of the API.
   */
  private @SafeText String functionType;

  /**
   * Priority of the Resource Function. Decides what happens in a contention
   * scenario.
   */
  private Integer priority;

  /**
   * Role of the Resource Function. Used when Resource Function is a component of
   * a composite Resource Function and the exact role of the service within the
   * composite is not clear from descriptor/location.
   */
  private @SafeText String role;

  /**
   * This is a reference to a schedule. Allows consumers to schedule modifications
   * to the service at certain times.
   */
  @JsonProperty("schedule")
  private List<@Valid ScheduleRef> schedules;
}