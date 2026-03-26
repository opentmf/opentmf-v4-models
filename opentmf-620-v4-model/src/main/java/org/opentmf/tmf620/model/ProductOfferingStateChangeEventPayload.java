package org.opentmf.tmf620.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

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
public class ProductOfferingStateChangeEventPayload implements IProductOfferingStateChangeEventPayload {

  /**
   * Represents entities that are orderable from the provider of the catalog, this
   * resource includes pricing information.
   */
  private @Valid ProductOffering productOffering;
}