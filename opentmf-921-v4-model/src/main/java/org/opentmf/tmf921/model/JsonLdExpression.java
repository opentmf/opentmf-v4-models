package org.opentmf.tmf921.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * JsonLdExpression is the ontology-encoded form of the Intent as specified by
 * JSON-LD expression language.
 *
 * <p><br/>
 * <strong>Required:</strong> @type, expressionLanguage, expressionValue<br/>
 * </p>
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
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = JsonLdExpression.class
)
@Required(fields = {"expressionValue", "atType", "expressionLanguage"})
public class JsonLdExpression extends Expression implements IJsonLdExpression {

  /**
   * JsonLdExpression is the ontology-encoded form of the Intent as defined in
   * https://www.w3.org/TR/json-ld/. This should be validated against
   * https://raw.githubusercontent.com/json-ld/json-ld.org/main/schemas/jsonld-schema.json.
   */
  private @SafeText String expressionValue;
}