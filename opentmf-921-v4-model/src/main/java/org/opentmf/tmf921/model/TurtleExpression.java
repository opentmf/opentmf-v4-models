package org.opentmf.tmf921.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * TurtleExpression is the ontology-encoded form of the Intent as Turtle RDF.
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
    defaultImpl = TurtleExpression.class
)
@Required(fields = {"expressionValue", "atType", "expressionLanguage"})
public class TurtleExpression extends Expression implements ITurtleExpression {

  /**
   * TurtleExpression is the ontology-encoded form of the Intent as Turtle RDF as
   * defined in https://www.w3.org/TR/turtle/.
   */
  private @SafeText String expressionValue;
}