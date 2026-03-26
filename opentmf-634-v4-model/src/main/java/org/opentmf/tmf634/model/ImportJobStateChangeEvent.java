package org.opentmf.tmf634.model;

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
 *   <li>TMF-634: Resource Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ImportJobStateChangeEvent extends EventBase implements IImportJobStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ImportJobStateChangeEventPayload event;
}