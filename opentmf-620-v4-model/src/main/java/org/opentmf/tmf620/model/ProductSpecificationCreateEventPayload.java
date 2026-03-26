package org.opentmf.tmf620.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.product.model.ProductSpecification;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ProductSpecificationCreateEventPayload implements IProductSpecificationCreateEventPayload {

  /**
   * Is a detailed description of a tangible or intangible object made available
   * externally in the form of a ProductOffering to customers or other parties
   * playing a party role.
   */
  private @Valid ProductSpecification productSpecification;
}