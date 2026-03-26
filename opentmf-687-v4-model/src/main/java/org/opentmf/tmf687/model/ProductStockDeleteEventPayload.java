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
public class ProductStockDeleteEventPayload implements IProductStockDeleteEventPayload {

  /**
   * ProductStock is a base class for defining a product (or configured product
   * with values characteristic) stock level.
   */
  private @Valid ProductStock productStock;
}