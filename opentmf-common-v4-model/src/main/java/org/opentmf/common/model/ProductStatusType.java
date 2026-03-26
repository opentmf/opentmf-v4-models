package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the status of the product.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
 *   <li>TMF-680: Recommendation Management API</li>
 *   <li>TMF-687: Stock Management API</li>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-717: Customer360 Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ProductStatusType {

  CREATED("created"),
  PENDING_ACTIVE("pendingActive"),
  CANCELLED("cancelled"),
  ACTIVE("active"),
  PENDING_TERMINATE("pendingTerminate"),
  TERMINATED("terminated"),
  SUSPENDED("suspended"),
  ABORTED("aborted");

  private final String value;

  ProductStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ProductStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (ProductStatusType productStatusType : values()) {
      REVERSE_MAP.put(productStatusType.getValue(), productStatusType);
    }
  }

  @JsonCreator
  public static ProductStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
