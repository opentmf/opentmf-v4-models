package org.opentmf.tmf701.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-701: Process Flow Management API</li>
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
    defaultImpl = TaskFlow.class
)
public class TaskFlow extends TaskFlowCreate implements ITaskFlow {

  /**
   * TaskFlow completion method.
   */
  private @SafeText String completionMethod;

  /**
   * Reference of the taskFlow.
   */
  private URI href;

  /**
   * Identifier of the taskFlow.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Indicate mandatory TaskFlow.
   */
  private Boolean isMandatory;

  /**
   * TaskFlow priority.
   */
  private Integer priority;

  /**
   * Valid values for the lifecycle state of the taskFlow
   * <br/><p>Recommended values: new, active, hold, cancelled, completed.
   *
   * @see org.opentmf.tmf701.model.TaskFlowStateType
   */
  private @SafeText String state;
}