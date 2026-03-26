package org.opentmf.product.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the status of the Usage.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-635: Usage Management API</li>
 *   <li>TMF-658: Loyalty</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum UsageStatusType {

  RECEIVED("received"),
  REJECTED("rejected"),
  RECYCLED("recycled"),
  GUIDED("guided"),
  RATED("rated"),
  RERATED("rerated"),
  BILLED("billed");

  private final String value;

  UsageStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, UsageStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (UsageStatusType usageStatusType : values()) {
      REVERSE_MAP.put(usageStatusType.getValue(), usageStatusType);
    }
  }

  @JsonCreator
  public static UsageStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
