package org.opentmf.tmf620.model;

import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A collection of Product Offerings, intended for a specific
 * DistributionChannel, enhanced with additional information such as SLA
 * parameters, invoicing and shipping details.
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
public class Catalog extends CatalogCreate implements ICatalog {

  /**
   * Unique reference of the catalog.
   */
  private URI href;

  /**
   * Unique identifier of the Catalog.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}