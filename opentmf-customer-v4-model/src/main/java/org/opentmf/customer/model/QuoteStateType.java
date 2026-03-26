package org.opentmf.customer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the state of the quote.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-717: Customer360 Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum QuoteStateType {

  REJECTED("rejected"),
  PENDING("pending"),
  IN_PROGRESS("inProgress"),
  CANCELLED("cancelled"),
  APPROVED("approved"),
  ACCEPTED("accepted");

  private final String value;

  QuoteStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, QuoteStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (QuoteStateType quoteStateType : values()) {
      REVERSE_MAP.put(quoteStateType.getValue(), quoteStateType);
    }
  }

  @JsonCreator
  public static QuoteStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
