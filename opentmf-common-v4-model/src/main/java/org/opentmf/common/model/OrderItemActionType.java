package org.opentmf.common.model;

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
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-640: Service Activation Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-645: Service Qualification Management API</li>
 *   <li>TMF-915: AI Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum OrderItemActionType {

  ADD("add"),
  MODIFY("modify"),
  DELETE("delete"),
  NO_CHANGE("noChange");

  private final String value;

  OrderItemActionType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, OrderItemActionType> REVERSE_MAP = new HashMap<>();

  static {
    for (OrderItemActionType orderItemActionType : values()) {
      REVERSE_MAP.put(orderItemActionType.getValue(), orderItemActionType);
    }
  }

  @JsonCreator
  public static OrderItemActionType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
