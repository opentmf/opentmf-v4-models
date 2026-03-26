package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the usage of the stock level - This is illustrative.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-687: Stock Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ProductStockUsageType {

  IN_TRANSIT("inTransit"),
  ON_DISPLAY("onDisplay"),
  DAMAGED("damaged"),
  RETURNED("returned"),
  REPLENISHMENT_IN_PROGRESS("replenishmentInProgress"),
  IN_SHOP("inShop");

  private final String value;

  ProductStockUsageType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ProductStockUsageType> REVERSE_MAP = new HashMap<>();

  static {
    for (ProductStockUsageType productStockUsageType : values()) {
      REVERSE_MAP.put(productStockUsageType.getValue(), productStockUsageType);
    }
  }

  @JsonCreator
  public static ProductStockUsageType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
