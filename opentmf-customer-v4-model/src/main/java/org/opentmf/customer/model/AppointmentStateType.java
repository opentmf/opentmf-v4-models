package org.opentmf.customer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for the lifecycle state of the appointment.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-646: Appointment Management API</li>
 *   <li>TMF-717: Customer360 Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum AppointmentStateType {

  INITIALIZED("initialized"),
  CONFIRMED("confirmed"),
  CANCELLED("cancelled"),
  COMPLETED("completed"),
  FAILED("failed");

  private final String value;

  AppointmentStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, AppointmentStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (AppointmentStateType appointmentStateType : values()) {
      REVERSE_MAP.put(appointmentStateType.getValue(), appointmentStateType);
    }
  }

  @JsonCreator
  public static AppointmentStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
