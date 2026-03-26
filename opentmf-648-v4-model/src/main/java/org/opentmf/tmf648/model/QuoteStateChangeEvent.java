package org.opentmf.tmf648.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AddressableEventBase;

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
public class QuoteStateChangeEvent extends AddressableEventBase implements IQuoteStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid QuoteStateChangeEventPayload event;
}