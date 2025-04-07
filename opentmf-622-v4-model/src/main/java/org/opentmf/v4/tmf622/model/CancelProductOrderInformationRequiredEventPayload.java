package org.opentmf.v4.tmf622.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class CancelProductOrderInformationRequiredEventPayload {

  /**
   * The involved resource data for the event.
   */
  private @Valid CancelProductOrder cancelProductOrder;
}