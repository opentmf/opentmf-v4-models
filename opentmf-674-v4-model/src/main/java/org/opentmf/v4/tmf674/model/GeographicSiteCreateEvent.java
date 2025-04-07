package org.opentmf.v4.tmf674.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.common.model.AddressableEventBase;

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
 * @author Gokhan Demir
 */
@Getter
@Setter
public class GeographicSiteCreateEvent extends AddressableEventBase {

  /**
   * The event payload linked to the involved resource object.
   */
  private @Valid GeographicSiteCreateEventPayload event;
}