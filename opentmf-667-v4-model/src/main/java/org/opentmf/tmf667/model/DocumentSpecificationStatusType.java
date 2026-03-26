package org.opentmf.tmf667.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the status of a DocumentSpecification.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-667: Document Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum DocumentSpecificationStatusType {

  CREATED("created"),
  REVIEWED("reviewed"),
  APPROVED("approved"),
  PUBLISHED("published"),
  ARCHIVED("archived"),
  DELETED("deleted");

  private final String value;

  DocumentSpecificationStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, DocumentSpecificationStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (DocumentSpecificationStatusType documentSpecificationStatusType : values()) {
      REVERSE_MAP.put(documentSpecificationStatusType.getValue(), documentSpecificationStatusType);
    }
  }

  @JsonCreator
  public static DocumentSpecificationStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
