package org.opentmf.v4.common.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An amount in a given unit.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-651: Agreement</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-681: Communication Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class Quantity {

  /**
   * Numeric value in a given unit.
   */
  private BigDecimal amount;

  /**
   * Unit.
   */
  private @SafeText String units;
}