package org.opentmf.v4.tmf673.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-673: Geographic Address Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class GeographicAddressValidationStateChangeEventPayload {

  /**
   * The involved resource data for the event.
   */
  private @Valid GeographicAddressValidation geographicAddressValidation;
}