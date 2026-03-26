package org.opentmf.tmf699.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Urgency of working this salesLead.
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
public enum SalesLeadPriorityType {

  LOW("low"),
  MEDIUM("medium"),
  HIGH("high");

  private final String value;

  SalesLeadPriorityType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, SalesLeadPriorityType> REVERSE_MAP = new HashMap<>();

  static {
    for (SalesLeadPriorityType salesLeadPriorityType : values()) {
      REVERSE_MAP.put(salesLeadPriorityType.getValue(), salesLeadPriorityType);
    }
  }

  @JsonCreator
  public static SalesLeadPriorityType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
