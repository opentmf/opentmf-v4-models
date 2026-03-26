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
public class ServiceLevelSpecificationCreateEventPayload implements IServiceLevelSpecificationCreateEventPayload {

  /**
   * A Service Level Specification represents a pre-defined or negotiated set of
   * Service Level 
   * <br/>Objectives. In addition, certain consequences are associated with not
   * meeting the Service Level 
   * <br/>Objectives. Service Level Agreements are expressed in terms of Service
   * Level Specifications.
   */
  private @Valid ServiceLevelSpecification serviceLevelSpecification;
}