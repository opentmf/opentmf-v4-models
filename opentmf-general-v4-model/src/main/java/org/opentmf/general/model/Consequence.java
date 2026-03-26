package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A threshold crossing or a threshold ceased to be crossing results in a
 * Performance consequence.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-649: Performance Thresholding Management API</li>
 *   <li>TMF-915: AI Management API</li>
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
    defaultImpl = Consequence.class
)
public class Consequence extends NamedEntity implements IConsequence {

  /**
   * A description of a Consequence.
   */
  private @SafeText String description;

  /**
   * The suggested action.
   */
  private @SafeText String prescribedAction;
}