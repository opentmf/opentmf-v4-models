package org.opentmf.v4.tmf620.model;

import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Represents entities that are orderable from the provider of the catalog, this
 * resource includes pricing information.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class ProductOffering extends ProductOfferingCreate {

  /**
   * Unique identifier of the productOffering.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Reference of the ProductOffering.
   */
  private URI href;
}