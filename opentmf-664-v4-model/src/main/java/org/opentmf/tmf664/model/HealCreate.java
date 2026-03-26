package org.opentmf.tmf664.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Task Resource used to request healing of a Resource Function
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> cause, degreeOfHealing, resourceFunction<br/>
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
    defaultImpl = HealCreate.class
)
@Required(fields = {"degreeOfHealing", "cause", "resourceFunction"})
public class HealCreate extends Extensible implements IHealCreate {

  /**
   * Additional parameters to be sent to the heal action as name value pairs.
   */
  @JsonProperty("additionalParms")
  private List<@Valid Characteristic> additionalParmses;

  /**
   * Reason why healing is being requested.
   */
  private @SafeText String cause;

  /**
   * Indicates the degree of healing required.
   */
  private @SafeText String degreeOfHealing;

  /**
   * Exact action to be taken as part of the heal process or a pointer to a script
   * to be run.
   */
  private @SafeText String healAction;

  /**
   * Heal policy reference.
   */
  private @Valid HealPolicyRef healPolicy;

  /**
   * Name of the Heal task resource.
   */
  private @SafeText String name;

  /**
   * Resource Function reference.
   */
  private @Valid ResourceFunctionRef resourceFunction;

  /**
   * The time when the heal action needs to commence. This allows a delay to be
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