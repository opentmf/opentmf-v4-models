package org.opentmf.tmf724.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class IncidentStateChangeEventPayload implements IIncidentStateChangeEventPayload {

  /**
   * An Incident is a record of an event that has altered the operational state of
   * a entity (Resource, Service or Customers Product). An incident represents an
   * issue that needs to be diagnosed and resolved.
   */
  private @Valid Incident incident;
}