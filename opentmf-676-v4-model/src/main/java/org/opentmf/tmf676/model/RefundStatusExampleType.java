package org.opentmf.tmf676.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the status of a refund.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-676: Payment Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum RefundStatusExampleType {

  PENDING_AUTHORIZATION("pendingAuthorization"),
  AUTHORIZED("authorized"),
  CAPTURED("captured"),
  FAILED("failed"),
  CANCELED("canceled"),
  DENIED("denied"),
  DONE("done");

  private final String value;

  RefundStatusExampleType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, RefundStatusExampleType> REVERSE_MAP = new HashMap<>();

  static {
    for (RefundStatusExampleType refundStatusExampleType : values()) {
      REVERSE_MAP.put(refundStatusExampleType.getValue(), refundStatusExampleType);
    }
  }

  @JsonCreator
  public static RefundStatusExampleType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
