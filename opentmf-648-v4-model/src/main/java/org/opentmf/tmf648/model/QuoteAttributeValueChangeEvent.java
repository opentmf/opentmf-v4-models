package org.opentmf.tmf648.model;

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
 *   <li>TMF-648: Quote Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class QuoteAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IQuoteAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid QuoteAttributeValueChangeEventPayload event;
}