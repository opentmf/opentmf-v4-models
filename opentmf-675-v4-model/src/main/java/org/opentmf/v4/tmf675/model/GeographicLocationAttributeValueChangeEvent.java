package org.opentmf.v4.tmf675.model;

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
 *   <li>TMF-675: Geographic Location API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class GeographicLocationAttributeValueChangeEvent extends EventBase {

  /**
   * The path identifying the object field concerned by this notification.
   */
  @SafeJsonPath
  private String fieldPath;

  /**
   * The event payload linked to the involved resource object.
   */
  private @Valid GeographicLocationAttributeValueChangeEventPayload event;
}