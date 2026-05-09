package org.opentmf.tmf915.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AiContractSpecification;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-915: AI Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AiContractSpecificationDeleteEventPayload implements IAiContractSpecificationDeleteEventPayload {

  /**
   * A template of an agreement that can be used when establishing partnerships.
   */
  private @Valid AiContractSpecification aiContractSpecification;
}