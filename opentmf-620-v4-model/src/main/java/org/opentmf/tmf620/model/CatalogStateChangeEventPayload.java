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
public class CatalogStateChangeEventPayload implements ICatalogStateChangeEventPayload {

  /**
   * A collection of Product Offerings, intended for a specific
   * DistributionChannel, enhanced with additional information such as SLA
   * parameters, invoicing and shipping details.
   */
  private @Valid Catalog catalog;
}