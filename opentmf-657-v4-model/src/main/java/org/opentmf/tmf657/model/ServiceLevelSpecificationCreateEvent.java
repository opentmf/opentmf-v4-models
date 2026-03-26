package org.opentmf.tmf657.model;

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
 *   <li>TMF-657: Service Quality Management Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceLevelSpecificationCreateEvent extends AddressableEventBase implements IServiceLevelSpecificationCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid ServiceLevelSpecificationCreateEventPayload event;
}