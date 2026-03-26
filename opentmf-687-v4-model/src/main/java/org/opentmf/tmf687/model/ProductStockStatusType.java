package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the status of the stock level.
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
public enum ProductStockStatusType {

  RESERVED("reserved"),
  AVAILABLE("available"),
  UNAVAILABLE("unavailable"),
  UNKNOWN("unknown");

  private final String value;

  ProductStockStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ProductStockStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (ProductStockStatusType productStockStatusType : values()) {
      REVERSE_MAP.put(productStockStatusType.getValue(), productStockStatusType);
    }
  }

  @JsonCreator
  public static ProductStockStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
