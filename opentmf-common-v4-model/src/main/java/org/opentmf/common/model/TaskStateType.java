package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the state of a task.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-645: Service Qualification Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-673: Geographic Address Management API</li>
 *   <li>TMF-677: Usage Consumption Management API</li>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
 *   <li>TMF-680: Recommendation Management API</li>
 *   <li>TMF-686: Topology API</li>
 *   <li>TMF-687: Stock Management API</li>
 *   <li>TMF-714: Work Qualification Management</li>
 *   <li>TMF-716: ResourceReservation</li>
 *   <li>TMF-724: Incident Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum TaskStateType {

  ACKNOWLEDGED("acknowledged"),
  TERMINATED_WITH_ERROR("terminatedWithError"),
  IN_PROGRESS("inProgress"),
  DONE("done");

  private final String value;

  TaskStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, TaskStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (TaskStateType taskStateType : values()) {
      REVERSE_MAP.put(taskStateType.getValue(), taskStateType);
    }
  }

  @JsonCreator
  public static TaskStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
