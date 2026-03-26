package org.opentmf.tmf674.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AddressableEventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-674: Geographic Site Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class GeographicSiteCreateEvent extends AddressableEventBase implements IGeographicSiteCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid GeographicSiteCreateEventPayload event;
}