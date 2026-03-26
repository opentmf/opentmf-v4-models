package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for the usage type are.
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
public enum UsageType {

  MONETARY("monetary"),
  VOICE("voice"),
  DATA("data"),
  SMS("sms"),
  OTHER("other");

  private final String value;

  UsageType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, UsageType> REVERSE_MAP = new HashMap<>();

  static {
    for (UsageType usageType : values()) {
      REVERSE_MAP.put(usageType.getValue(), usageType);
    }
  }

  @JsonCreator
  public static UsageType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
