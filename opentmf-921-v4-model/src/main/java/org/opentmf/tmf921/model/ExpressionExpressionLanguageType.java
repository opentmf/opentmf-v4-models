package org.opentmf.tmf921.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * ExpressionLanguage values for Expression.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-921: Intent Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ExpressionExpressionLanguageType {

  TURTLE("Turtle"),
  JSON_LD("JSON-LD"),
  RDF_XML("RDF-XML");

  private final String value;

  ExpressionExpressionLanguageType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ExpressionExpressionLanguageType> REVERSE_MAP = new HashMap<>();

  static {
    for (ExpressionExpressionLanguageType expressionExpressionLanguageType : values()) {
      REVERSE_MAP.put(expressionExpressionLanguageType.getValue(), expressionExpressionLanguageType);
    }
  }

  @JsonCreator
  public static ExpressionExpressionLanguageType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
