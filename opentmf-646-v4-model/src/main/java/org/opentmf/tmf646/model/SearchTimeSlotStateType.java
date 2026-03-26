package org.opentmf.tmf646.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for the lifecycle state of the searchTimeSlot.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-646: Appointment Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum SearchTimeSlotStateType {

  IN_PROGRESS("inProgress"),
  DONE("done"),
  REJECTED("rejected"),
  TERMINATED_WITH_ERROR("terminatedWithError");

  private final String value;

  SearchTimeSlotStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, SearchTimeSlotStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (SearchTimeSlotStateType searchTimeSlotStateType : values()) {
      REVERSE_MAP.put(searchTimeSlotStateType.getValue(), searchTimeSlotStateType);
    }
  }

  @JsonCreator
  public static SearchTimeSlotStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
