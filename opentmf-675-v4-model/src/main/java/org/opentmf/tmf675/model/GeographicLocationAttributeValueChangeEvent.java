package org.opentmf.tmf675.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttributeValueChangeEventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-675: Geographic Location Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class GeographicLocationAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IGeographicLocationAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid GeographicLocationAttributeValueChangeEventPayload event;
}