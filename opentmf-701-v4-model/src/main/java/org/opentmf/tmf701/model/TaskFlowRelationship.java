package org.opentmf.tmf701.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.TaskFlowRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Describes relationship between taskFlow.
 *
 * <p><br/>
 * <strong>Required:</strong> relationshipType, taskFlow<br/>
 * </p>
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
@Required(fields = {"relationshipType", "taskFlow"})
public class TaskFlowRelationship implements ITaskFlowRelationship {

  /**
   * The type of taskFlow relationship (requires, triggers, etc.).
   */
  private @SafeText String relationshipType;

  private @Valid TaskFlowRef taskFlow;
}