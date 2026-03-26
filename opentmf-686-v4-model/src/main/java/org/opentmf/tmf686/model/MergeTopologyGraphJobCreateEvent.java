package org.opentmf.tmf686.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EventBase;

/**
 * The notification data structure.
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
public class MergeTopologyGraphJobCreateEvent extends EventBase implements IMergeTopologyGraphJobCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid MergeTopologyGraphJobCreateEventPayload event;
}