package org.opentmf.tmf651.model;

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
 *   <li>TMF-651: Agreement Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AgreementSpecificationAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IAgreementSpecificationAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid AgreementSpecificationAttributeValueChangeEventPayload event;
}