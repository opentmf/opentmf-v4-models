package org.opentmf.tmf705.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-705: Test Environment Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AbstractEnvironmentCreateEventPayload implements IAbstractEnvironmentCreateEventPayload {

  /**
   * A managed abstract environment resource.
   */
  private @Valid AbstractEnvironment abstractEnvironment;
}