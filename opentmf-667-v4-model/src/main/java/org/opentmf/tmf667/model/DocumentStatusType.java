package org.opentmf.tmf667.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the status of a Document.
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
public enum DocumentStatusType {

  CREATED("created"),
  REVIEWED("reviewed"),
  APPROVED("approved"),
  PUBLISHED("published"),
  ARCHIVED("archived"),
  DELETED("deleted");

  private final String value;

  DocumentStatusType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, DocumentStatusType> REVERSE_MAP = new HashMap<>();

  static {
    for (DocumentStatusType documentStatusType : values()) {
      REVERSE_MAP.put(documentStatusType.getValue(), documentStatusType);
    }
  }

  @JsonCreator
  public static DocumentStatusType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
