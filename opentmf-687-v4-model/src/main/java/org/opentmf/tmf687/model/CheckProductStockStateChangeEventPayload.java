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
public class CheckProductStockStateChangeEventPayload implements ICheckProductStockStateChangeEventPayload {

  /**
   * CheckProductStock is used to log and execute check about product stock
   * availability.
   */
  private @Valid CheckProductStock checkProductStock;
}