package org.opentmf.v4.tmf634.model;

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
 *   <li>TMF-634: Resource Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class ResourceCategoryDeleteEvent extends EventBase {

  /**
   * The event payload linked to the involved resource object.
   */
  private @Valid ResourceCategoryDeleteEventPayload event;
}