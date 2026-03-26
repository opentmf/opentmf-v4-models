package org.opentmf.tmf664.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.PlaceRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.resource.model.ConnectionPointRef;

/**
 * Task resource used to request migration of the Resource Function
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> cause, resourceFunction<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-664: Resource Function Activation Management API</li>
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
    defaultImpl = MigrateCreate.class
)
@Required(fields = {"cause", "resourceFunction"})
public class MigrateCreate extends Extensible implements IMigrateCreate {

  /**
   * Connection points to be added when function is migrated.
   */
  @JsonProperty("addConnectionPoint")
  private List<@Valid ConnectionPointRef> addConnectionPoints;

  /**
   * SubState required before migrate is carried out.
   */
  private @SafeText String adminStateModification;

  /**
   * Reason why migration is being requested.
   */
  private @SafeText String cause;

  /**
   * Additional attributes to pass to the migrate operation.
   */
  @JsonProperty("characteristics")
  private List<@Valid Characteristic> characteristicses;

  /**
   * In what mode is the migrate operation to be performed.
   */
  private @SafeText String completionMode;

  /**
   * Name of the Migrate task resource.
   */
  private @SafeText String name;

  /**
   * Place reference. PlaceRef defines the placeRefs where the products are sold
   * or delivered.
   */
  private @Valid PlaceRef place;

  /**
   * Priority of the migrate operation.
   */
  private Integer priority;

  /**
   * Connection points to be removed when function is migrated.
   */
  @JsonProperty("removeConnectionPoint")
  private List<@Valid ConnectionPointRef> removeConnectionPoints;

  /**
   * Resource Function reference.
   */
  private @Valid ResourceFunctionRef resourceFunction;

  /**
   * The time when the migration needs to commence. This allows a delay to be
   * added.
   */
  private @SafeText String startTime;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}