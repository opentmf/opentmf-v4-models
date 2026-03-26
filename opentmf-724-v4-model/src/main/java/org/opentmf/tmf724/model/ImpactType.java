package org.opentmf.tmf724.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the impact of an Incident.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-724: Incident Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ImpactType {

  EXTENSIVE("extensive"),
  SIGNIFICANT("significant"),
  MODERATE("moderate"),
  MINOR("minor");

  private final String value;

  ImpactType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ImpactType> REVERSE_MAP = new HashMap<>();

  static {
    for (ImpactType impactType : values()) {
      REVERSE_MAP.put(impactType.getValue(), impactType);
    }
  }

  @JsonCreator
  public static ImpactType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
