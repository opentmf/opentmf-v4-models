package org.opentmf.tmf703.model;

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
 *   <li>TMF-703: Entity Inventory Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class EntityChangeEvent extends EventBase implements IEntityChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid EntityChangeEventPayload event;
}