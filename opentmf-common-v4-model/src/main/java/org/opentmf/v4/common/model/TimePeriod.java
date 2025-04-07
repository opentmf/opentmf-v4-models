package org.opentmf.v4.common.model;

import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * A period of time, either as a deadline (endDateTime only) a startDateTime
 * only, or both.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-629: Customer Management API</li>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-651: Agreement</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-666: Account Management API</li>
 *   <li>TMF-669: Party Role Management API</li>
 *   <li>TMF-674: Geographic Site Management API</li>
 *   <li>TMF-681: Communication Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class TimePeriod {

  /**
   * End of the time period, using IETC-RFC-3339 format.
   */
  private OffsetDateTime endDateTime;

  /**
   * Start of the time period, using IETC-RFC-3339 format.
   */
  private OffsetDateTime startDateTime;
}