package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Recommended Enumeration Type (not formal forced in standard): Valid values
 * for the lifecycle state of the bill: new = 'bill is ready to validate or to
 * sent', validated = 'bill is checked (manual / automatic)', sent = 'bill is
 * sent with the channel defined in the billingaccount', settled = 'bill is
 * payed', partiallySettled = 'bill is partially payed', onHold = 'bill will not
 * be in further processing until open issues connected to the bill are solved'.
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
public enum CustomerBillStateType {

  NEW("new"),
  ON_HOLD("onHold"),
  VALIDATED("validated"),
  SENT("sent"),
  SETTLED("settled"),
  PARTIALLY_PAID("partiallyPaid");

  private final String value;

  CustomerBillStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, CustomerBillStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (CustomerBillStateType customerBillStateType : values()) {
      REVERSE_MAP.put(customerBillStateType.getValue(), customerBillStateType);
    }
  }

  @JsonCreator
  public static CustomerBillStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
