package org.opentmf.tmf679.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * action to be performed on the product.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ProductActionType {

  ADD("add"),
  MODIFY("modify"),
  DELETE("delete"),
  NO_CHANGE("noChange");

  private final String value;

  ProductActionType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ProductActionType> REVERSE_MAP = new HashMap<>();

  static {
    for (ProductActionType productActionType : values()) {
      REVERSE_MAP.put(productActionType.getValue(), productActionType);
    }
  }

  @JsonCreator
  public static ProductActionType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
