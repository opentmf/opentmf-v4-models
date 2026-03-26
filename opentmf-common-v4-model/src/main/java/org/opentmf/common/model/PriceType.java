package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Describes the type of price (ex: oneTime, recurring, etc).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-713: Work Management</li>
 *   <li>TMF-714: Work Qualification Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum PriceType {

  RECURRING("recurring"),
  ONE_TIME("oneTime"),
  USAGE("usage");

  private final String value;

  PriceType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, PriceType> REVERSE_MAP = new HashMap<>();

  static {
    for (PriceType priceType : values()) {
      REVERSE_MAP.put(priceType.getValue(), priceType);
    }
  }

  @JsonCreator
  public static PriceType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
