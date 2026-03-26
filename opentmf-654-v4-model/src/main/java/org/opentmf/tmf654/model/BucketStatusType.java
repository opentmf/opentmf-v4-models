package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid values for the Balance Status Type.
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
public enum BucketStatusType {

  ACTIVE("active"),
  SUSPENDED("suspended"),
  EXPIRED("expired");

  private final String value;

  BucketStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, BucketStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (BucketStatusType bucketStatusType : values()) {
      REVERSE_MAP.put(bucketStatusType.getValue(), bucketStatusType);
    }
  }

  @JsonCreator
  public static BucketStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
