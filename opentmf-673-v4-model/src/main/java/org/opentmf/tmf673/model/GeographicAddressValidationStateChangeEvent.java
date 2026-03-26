package org.opentmf.tmf673.model;

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
 *   <li>TMF-673: Geographic Address Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class GeographicAddressValidationStateChangeEvent extends EventBase implements IGeographicAddressValidationStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid GeographicAddressValidationStateChangeEventPayload event;
}