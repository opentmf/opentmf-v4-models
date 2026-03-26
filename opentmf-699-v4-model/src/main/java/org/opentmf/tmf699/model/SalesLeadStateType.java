package org.opentmf.tmf699.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for the lifecycle state of a salesLead resource.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-699: Sales Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum SalesLeadStateType {

  ACCEPTED("accepted"),
  ACKNOWLEDGED("acknowledged"),
  CANCELLED("cancelled"),
  IN_PROGRESS("inProgress"),
  PENDING("pending"),
  REJECTED("rejected");

  private final String value;

  SalesLeadStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, SalesLeadStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (SalesLeadStateType salesLeadStateType : values()) {
      REVERSE_MAP.put(salesLeadStateType.getValue(), salesLeadStateType);
    }
  }

  @JsonCreator
  public static SalesLeadStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
