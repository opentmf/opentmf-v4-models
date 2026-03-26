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
public class TopologyQueryJobCreateEventPayload implements ITopologyQueryJobCreateEventPayload {

  /**
   * Represents a task used to query topology in the service.
   */
  private @Valid TopologyQueryJob topologyQueryJob;
}