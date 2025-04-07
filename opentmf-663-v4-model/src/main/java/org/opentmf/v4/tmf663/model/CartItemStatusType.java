package org.opentmf.v4.tmf663.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the status of the cart item.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-663: Shopping Cart Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
public enum CartItemStatusType {

  ACTIVE("active"),
  SAVE_FOR_LATER("saveForLater");

  private final String value;

  CartItemStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, CartItemStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (CartItemStatusType cartItemStatusType : values()) {
      REVERSE_MAP.put(cartItemStatusType.getValue(), cartItemStatusType);
    }
  }

  @JsonCreator
  public static CartItemStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
