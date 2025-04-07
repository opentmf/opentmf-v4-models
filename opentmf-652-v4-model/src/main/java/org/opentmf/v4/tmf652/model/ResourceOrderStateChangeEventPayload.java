package org.opentmf.v4.tmf652.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-652: Resource Order Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class ResourceOrderStateChangeEventPayload {

  /**
   * The involved resource data for the event.
   */
  private @Valid ResourceOrder resourceOrder;
}