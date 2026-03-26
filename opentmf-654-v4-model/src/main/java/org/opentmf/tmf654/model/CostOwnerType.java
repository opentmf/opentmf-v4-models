package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for this type.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-654: Prepay Balance Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum CostOwnerType {

  ORIGINATOR("originator"),
  RECEIVER("receiver");

  private final String value;

  CostOwnerType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, CostOwnerType> REVERSE_MAP = new HashMap<>();

  static {
    for (CostOwnerType costOwnerType : values()) {
      REVERSE_MAP.put(costOwnerType.getValue(), costOwnerType);
    }
  }

  @JsonCreator
  public static CostOwnerType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
