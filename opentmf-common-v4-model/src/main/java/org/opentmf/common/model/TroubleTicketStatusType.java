package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the status of the trouble ticket.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-621: Trouble Ticket Management API</li>
 *   <li>TMF-717: Customer360 Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum TroubleTicketStatusType {

  ACKNOWLEDGED("acknowledged"),
  REJECTED("rejected"),
  PENDING("pending"),
  HELD("held"),
  IN_PROGRESS("inProgress"),
  CANCELLED("cancelled"),
  CLOSED("closed"),
  RESOLVED("resolved");

  private final String value;

  TroubleTicketStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, TroubleTicketStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (TroubleTicketStatusType troubleTicketStatusType : values()) {
      REVERSE_MAP.put(troubleTicketStatusType.getValue(), troubleTicketStatusType);
    }
  }

  @JsonCreator
  public static TroubleTicketStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
