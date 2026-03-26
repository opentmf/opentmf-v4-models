package org.opentmf.tmf657.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class ServiceLevelObjectiveCreateEventPayload implements IServiceLevelObjectiveCreateEventPayload {

  /**
   * Service level objectives are defined in terms of parameters and metrics,
   * thresholds, and tolerances 
   * <br/>associated with the parameters.
   */
  private @Valid ServiceLevelObjective serviceLevelObjective;
}