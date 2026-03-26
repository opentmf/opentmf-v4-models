package org.opentmf.tmf699.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttributeValueChangeEventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-699: Sales Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class SalesLeadAttributeValueChangeEvent extends AttributeValueChangeEventBase implements ISalesLeadAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid SalesLeadAttributeValueChangeEventPayload event;
}