package org.opentmf.tmf637.model;

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
 *   <li>TMF-637: Product Inventory Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ProductDeleteEvent extends AddressableEventBase implements IProductDeleteEvent {

  /**
   * The event data structure.
   */
  private @Valid ProductDeleteEventPayload event;
}