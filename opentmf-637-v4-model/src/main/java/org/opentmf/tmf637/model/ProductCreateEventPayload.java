package org.opentmf.tmf637.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Product;

/**
 * The event data structure.
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
public class ProductCreateEventPayload implements IProductCreateEventPayload {

  /**
   * A product offering procured by a customer or other interested party playing a
   * party role. A product is realized as one or more service(s) and / or
   * resource(s).
   */
  private @Valid Product product;
}