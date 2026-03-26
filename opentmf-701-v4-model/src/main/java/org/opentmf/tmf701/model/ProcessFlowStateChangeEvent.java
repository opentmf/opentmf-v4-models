package org.opentmf.tmf701.model;

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
 *   <li>TMF-701: Process Flow Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ProcessFlowStateChangeEvent extends EventBase implements IProcessFlowStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ProcessFlowStateChangeEventPayload event;
}