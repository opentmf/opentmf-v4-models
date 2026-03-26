package org.opentmf.tmf921.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Expression is the ontology-encoded form of the Intent.
 *
 * <p><br/>
 * <strong>Required:</strong> @type, expressionLanguage<br/>
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
    defaultImpl = Expression.class
)
@Required(fields = {"atType", "expressionLanguage"})
public class Expression extends Extensible implements IExpression {

  /**
   * The serialized Expression language of an intent or Intent report
   * <br/><p>Recommended values: Turtle, JSON-LD, RDF-XML.
   *
   * @see org.opentmf.tmf921.model.ExpressionExpressionLanguageType
   */
  private @SafeText String expressionLanguage;

  /**
   * Internationalized Resource Identifier of the intent Expression.
   */
  private @SafeText String iri;
}