package org.opentmf.v4.tmf675.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.common.model.GeographicLocation;

/**
 * The event data structure.
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
public class GeographicLocationCreateEventPayload {

  /**
   * The involved resource data for the event.
   */
  private @Valid GeographicLocation geographicLocation;
}