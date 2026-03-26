package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Recommended Enumeration Type (not formal forced in standard): Valid values
 * for the runType of a bill. The bill could be produced in a regular bill cycle
 * 'onCycle'. Otherwise the bill is produced on a request (e.g. customer
 * request). This could be indicated by 'offCycle'.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-717: Customer360 Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum CustomerBillRunType {

  ON_CYCLE("onCycle"),
  OFF_CYCLE("offCycle");

  private final String value;

  CustomerBillRunType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, CustomerBillRunType> REVERSE_MAP = new HashMap<>();

  static {
    for (CustomerBillRunType customerBillRunType : values()) {
      REVERSE_MAP.put(customerBillRunType.getValue(), customerBillRunType);
    }
  }

  @JsonCreator
  public static CustomerBillRunType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
