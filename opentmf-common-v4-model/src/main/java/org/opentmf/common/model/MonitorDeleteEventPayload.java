package org.opentmf.common.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-640: Service Activation Management API</li>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
 *   <li>TMF-915: AI Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class MonitorDeleteEventPayload implements IMonitorDeleteEventPayload {

  /**
   * Monitoring of resources.
   */
  private @Valid Monitor monitor;
}