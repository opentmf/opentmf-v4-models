package org.opentmf.tmf915.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Categorizes the alarm (X.733 8.1.1, 3GPP TS 32.111-2 Annex A).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-915: AI Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum AlarmType {

  COMMUNICATIONS_ALARM("communicationsAlarm"),
  PROCESSING_ERROR_ALARM("processingErrorAlarm"),
  ENVIRONMENTAL_ALARM("environmentalAlarm"),
  QUALITY_OF_SERVICE_ALARM("qualityOfServiceAlarm"),
  EQUIPMENT_ALARM("equipmentAlarm"),
  INTEGRITY_VIOLATION("integrityViolation"),
  OPERATIONAL_VIOLATION("operationalViolation"),
  PHYSICAL_VIOLATION("physicalViolation"),
  SECURITY_SERVICE("securityService"),
  MECHANISM_VIOLATION("mechanismViolation"),
  TIME_DOMAIN_VIOLATION("timeDomainViolation");

  private final String value;

  AlarmType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, AlarmType> REVERSE_MAP = new HashMap<>();

  static {
    for (AlarmType alarmType : values()) {
      REVERSE_MAP.put(alarmType.getValue(), alarmType);
    }
  }

  @JsonCreator
  public static AlarmType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
