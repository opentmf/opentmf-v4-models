package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for the state of a batch job (e.g. catalog import).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
public enum JobStateType {

  NOT_STARTED("Not Started"),
  RUNNING("Running"),
  SUCCEEDED("Succeeded"),
  FAILED("Failed");

  private final String value;

  JobStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, JobStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (JobStateType jobStateType : values()) {
      REVERSE_MAP.put(jobStateType.getValue(), jobStateType);
    }
  }

  @JsonCreator
  public static JobStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
