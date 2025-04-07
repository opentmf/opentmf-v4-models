package org.opentmf.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the state of the order item.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-641: Service Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
public enum ServiceOrderItemStateType {

  ACKNOWLEDGED("acknowledged"),
  REJECTED("rejected"),
  PENDING("pending"),
  HELD("held"),
  IN_PROGRESS("inProgress"),
  CANCELLED("cancelled"),
  COMPLETED("completed"),
  FAILED("failed"),
  ASSESSING_CANCELLATION("assessingCancellation"),
  PENDING_CANCELLATION("pendingCancellation"),
  PARTIAL("partial");

  private final String value;

  ServiceOrderItemStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ServiceOrderItemStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ServiceOrderItemStateType serviceOrderItemStateType : values()) {
      REVERSE_MAP.put(serviceOrderItemStateType.getValue(), serviceOrderItemStateType);
    }
  }

  @JsonCreator
  public static ServiceOrderItemStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
