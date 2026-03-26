package org.opentmf.tmf655.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the state of the change request.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-655: Change Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ChangeRequestStatusType {

  ACKNOWLEDGED("acknowledged"),
  REQUEST_FOR_AUTHORIZATION("requestForAuthorization"),
  WAIT_FOR_APPROVAL("waitForApproval"),
  APPROVED("approved"),
  SCHEDULED("scheduled"),
  POST_IMPLEMENTATION_REVIEW("postImplementationReview"),
  FALLBACK_EXECUTION("fallbackExecution"),
  CANCELLED("cancelled"),
  REJECTED("rejected"),
  IN_PROGRESS("inProgress"),
  FAILED("failed"),
  COMPLETED("completed");

  private final String value;

  ChangeRequestStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ChangeRequestStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (ChangeRequestStatusType changeRequestStatusType : values()) {
      REVERSE_MAP.put(changeRequestStatusType.getValue(), changeRequestStatusType);
    }
  }

  @JsonCreator
  public static ChangeRequestStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
