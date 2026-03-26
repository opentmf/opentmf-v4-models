package org.opentmf.tmf653.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-653: Service Test Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceTestAttributeValueChangeEventPayload implements IServiceTestAttributeValueChangeEventPayload {

  /**
   * A service test is an entity that exists for a controlled test invocation on a
   * service. The service 
   * <br/>test is executed according to a schedule and contains service test
   * configuration parameters that are to be 
   * <br/>applied at execution time, and service test measures that result.
   */
  private @Valid ServiceTest serviceTest;
}