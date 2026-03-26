package org.opentmf.tmf921.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * RdxmlExpression is the ontology-encoded form of the Intent as RDF-XML.
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
    defaultImpl = RdxmlExpression.class
)
@Required(fields = {"expressionValue", "atType", "expressionLanguage"})
public class RdxmlExpression extends Expression implements IRdxmlExpression {

  /**
   * RdxmlExpression is the ontology-encoded form of the Intent as RDF-XML as
   * defined in https://www.w3.org/TR/rdf-syntax-grammar/.
   */
  private @SafeText String expressionValue;
}