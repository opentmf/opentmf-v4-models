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
public class AgreementAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IAgreementAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid AgreementAttributeValueChangeEventPayload event;
}