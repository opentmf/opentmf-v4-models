package org.opentmf.tmf921.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An Intent instance is the formal description of all expectations including
 * requirements, goals, and constraints given to a technical system
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> expression, name<br/>
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
@Required(fields = {"expression", "name"})
public class IntentCreate extends IntentUpdate implements IIntentCreate {

  /**
   * When subclassing, this defines the subclass Extensible name.
   */
  @JsonProperty("@type")
  private @SafeText String atType;
}