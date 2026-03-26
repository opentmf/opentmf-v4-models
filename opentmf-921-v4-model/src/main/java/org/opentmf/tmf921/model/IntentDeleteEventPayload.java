package org.opentmf.tmf921.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-921: Intent Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class IntentDeleteEventPayload implements IIntentDeleteEventPayload {

  /**
   * An Intent instance is the formal description of all expectations including
   * requirements, goals, and constraints given to a technical system.
   */
  private @Valid Intent intent;
}