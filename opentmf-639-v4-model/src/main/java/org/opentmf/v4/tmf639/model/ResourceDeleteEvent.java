package org.opentmf.v4.tmf639.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.common.model.EventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class ResourceDeleteEvent extends EventBase {

  /**
   * The event payload linked to the involved resource object.
   */
  private @Valid ResourceDeleteEventPayload event;
}