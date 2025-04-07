package org.opentmf.v4.tmf620.model;

import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Is a detailed description of a tangible or intangible object made available
 * externally in the form of a ProductOffering to customers or other parties
 * playing a party role.
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
public class ProductSpecification extends ProductSpecificationCreate {

  /**
   * Unique identifier of the product specification.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Reference of the product specification.
   */
  private URI href;
}