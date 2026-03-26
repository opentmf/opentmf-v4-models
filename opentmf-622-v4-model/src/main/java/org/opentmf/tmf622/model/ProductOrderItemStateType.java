package org.opentmf.tmf622.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the state of the product order item.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ProductOrderItemStateType {

  ACKNOWLEDGED("acknowledged"),
  REJECTED("rejected"),
  PENDING("pending"),
  HELD("held"),
  IN_PROGRESS("inProgress"),
  CANCELLED("cancelled"),
  COMPLETED("completed"),
  FAILED("failed"),
  ASSESSING_CANCELLATION("assessingCancellation"),
  PENDING_CANCELLATION("pendingCancellation");

  private final String value;

  ProductOrderItemStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ProductOrderItemStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ProductOrderItemStateType productOrderItemStateType : values()) {
      REVERSE_MAP.put(productOrderItemStateType.getValue(), productOrderItemStateType);
    }
  }

  @JsonCreator
  public static ProductOrderItemStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
