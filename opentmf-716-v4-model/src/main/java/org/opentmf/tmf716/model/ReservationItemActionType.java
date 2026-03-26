package org.opentmf.tmf716.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * action to be performed on the entity.
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
public enum ReservationItemActionType {

  ADD("add"),
  MODIFY("modify"),
  DELETE("delete"),
  NO_CHANGE("noChange");

  private final String value;

  ReservationItemActionType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ReservationItemActionType> REVERSE_MAP = new HashMap<>();

  static {
    for (ReservationItemActionType reservationItemActionType : values()) {
      REVERSE_MAP.put(reservationItemActionType.getValue(), reservationItemActionType);
    }
  }

  @JsonCreator
  public static ReservationItemActionType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
