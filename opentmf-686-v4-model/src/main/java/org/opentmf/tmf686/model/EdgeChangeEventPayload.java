package org.opentmf.tmf686.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-686: Topology API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class EdgeChangeEventPayload implements IEdgeChangeEventPayload {

  /**
   * Edge is a directed edge connecting vertices in a directed Graph.
   */
  private @Valid Edge edge;
}