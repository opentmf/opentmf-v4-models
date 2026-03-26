package org.opentmf.tmf687.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-687: Stock Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AdjustProductStockStateChangeEventPayload implements IAdjustProductStockStateChangeEventPayload {

  /**
   * AdjustProductStock is used to log and execute on or several Product Stock
   * level change.
   */
  private @Valid AdjustProductStock adjustProductStock;
}