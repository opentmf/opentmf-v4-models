package org.opentmf.tmf664.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.resource.model.ScheduleRef;

/**
 * Task Resource used to request scaling of a Resource Function
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> numberOfSteps, resourceFunction, scaleType<br/>
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
    defaultImpl = ScaleCreate.class
)
@Required(fields = {"numberOfSteps", "scaleType", "resourceFunction"})
public class ScaleCreate extends Extensible implements IScaleCreate {

  /**
   * Scaling aspect is the dimension along which the Resource Function needs to be
   * scaled. The id of the aspect is provided here.
   */
  @SafeId
  @Size(max = 100)
  private String aspectId;

  /**
   * Name of the Scale task resource.
   */
  private @SafeText String name;

  /**
   * Number of scaling steps in the direction indicated by type of scale.
   */
  private Integer numberOfSteps;

  /**
   * Resource Function reference.
   */
  private @Valid ResourceFunctionRef resourceFunction;

  /**
   * Type of scaling requested.
   */
  private @SafeText String scaleType;

  /**
   * Schedule for the scale. If not provided then needs to be actioned
   * immediately.
   */
  @JsonProperty("schedule")
  private List<@Valid ScheduleRef> schedules;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}