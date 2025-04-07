package org.opentmf.v4.tmf651.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class AgreementSpecificationCreateEventPayload {

  /**
   * The involved resource data for the event.
   */
  private @Valid AgreementSpecification agreementSpecification;
}