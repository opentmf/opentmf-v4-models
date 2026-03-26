package org.opentmf.tmf663.model;

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
 *   <li>TMF-663: Shopping Cart Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum CartItemActionType {

  ADD("add"),
  MODIFY("modify"),
  DELETE("delete"),
  NO_CHANGE("noChange");

  private final String value;

  CartItemActionType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, CartItemActionType> REVERSE_MAP = new HashMap<>();

  static {
    for (CartItemActionType cartItemActionType : values()) {
      REVERSE_MAP.put(cartItemActionType.getValue(), cartItemActionType);
    }
  }

  @JsonCreator
  public static CartItemActionType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
