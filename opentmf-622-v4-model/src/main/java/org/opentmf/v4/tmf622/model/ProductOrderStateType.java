package org.opentmf.v4.tmf622.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the state of the order.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
public enum ProductOrderStateType {

  ACKNOWLEDGED("acknowledged"),
  REJECTED("rejected"),
  PENDING("pending"),
  HELD("held"),
  IN_PROGRESS("inProgress"),
  CANCELLED("cancelled"),
  COMPLETED("completed"),
  FAILED("failed"),
  PARTIAL("partial"),
  ASSESSING_CANCELLATION("assessingCancellation"),
  PENDING_CANCELLATION("pendingCancellation");

  private final String value;

  ProductOrderStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ProductOrderStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ProductOrderStateType productOrderStateType : values()) {
      REVERSE_MAP.put(productOrderStateType.getValue(), productOrderStateType);
    }
  }

  @JsonCreator
  public static ProductOrderStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
