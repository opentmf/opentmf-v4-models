package org.opentmf.tmf635.model;

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
 *   <li>TMF-635: Usage Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class UsageSpecificationDeleteEvent extends EventBase implements IUsageSpecificationDeleteEvent {

  /**
   * The event data structure.
   */
  private @Valid UsageSpecificationDeleteEventPayload event;
}