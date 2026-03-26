package org.opentmf.tmf701.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class TaskFlowSpecificationDeleteEventPayload implements ITaskFlowSpecificationDeleteEventPayload {

  /**
   * TaskFlowSpecification is a class that allow to describe a TaskFlow
   * specification design. A TaskFlow instance as used in TMF701 will use a
   * TaskFlowSpecification as reference.
   */
  private @Valid TaskFlowSpecification taskFlowSpecification;
}