package org.opentmf.v4.tmf652.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeJsonPath;
import org.opentmf.v4.common.model.EventBase;

/**
 * The notification data structure.
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
public class ResourceOrderAttributeValueChangeEvent extends EventBase {

  /**
   * The path identifying the object field concerned by this notification.
   */
  @SafeJsonPath
  private String fieldPath;

  /**
   * The event payload linked to the involved resource object.
   */
  private @Valid ResourceOrderAttributeValueChangeEventPayload event;
}