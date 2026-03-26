package org.opentmf.tmf655.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-655: Change Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ChangeRequestApprovalRequiredEventPayload implements IChangeRequestApprovalRequiredEventPayload {

  /**
   * Change Request is a type of request which can be used for the management and
   * control of Change Management process 
   * <br/> -within a service provider organisation or 
   * <br/> -between a customer and a service provider or 
   * <br/> -between a service provider and a partner and vice versa.
   */
  private @Valid ChangeRequest changeRequest;
}