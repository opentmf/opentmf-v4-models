package org.opentmf.tmf724.model;

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
 *   <li>TMF-724: Incident Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class DiagnoseIncidentCreateEvent extends EventBase implements IDiagnoseIncidentCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid DiagnoseIncidentCreateEventPayload event;
}