package org.opentmf.tmf645.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-645: Service Qualification Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CheckServiceQualificationStateChangeEventPayload implements ICheckServiceQualificationStateChangeEventPayload {

  /**
   * CheckServiceQualification is used to perform a technical eligibility on
   * service configuration(s). It allows to retrieve services that are technically
   * available in the context of the interaction (place, party, service
   * characteristics, ...).
   */
  private @Valid CheckServiceQualification checkServiceQualification;
}