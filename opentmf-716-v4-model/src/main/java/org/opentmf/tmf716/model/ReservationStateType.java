package org.opentmf.tmf716.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-716: ResourceReservation</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ReservationStateType {

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

  ReservationStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ReservationStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ReservationStateType reservationStateType : values()) {
      REVERSE_MAP.put(reservationStateType.getValue(), reservationStateType);
    }
  }

  @JsonCreator
  public static ReservationStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
