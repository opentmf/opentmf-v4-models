package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for the Balance Adjust types.
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
public enum AdjustType {

  RECURRING("recurring"),
  ONE_TIME("oneTime");

  private final String value;

  AdjustType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, AdjustType> REVERSE_MAP = new HashMap<>();

  static {
    for (AdjustType adjustType : values()) {
      REVERSE_MAP.put(adjustType.getValue(), adjustType);
    }
  }

  @JsonCreator
  public static AdjustType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
