package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-686: Topology API</li>
 *   <li>TMF-general: general</li>
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
    defaultImpl = EdgeCreateBase.class
)
public abstract class EdgeCreateBase extends Extensible implements IEdgeCreateBase {

  /**
   * Description of this REST resource.
   */
  private @SafeText String description;

  /**
   * Entity reference schema to be used for all entityRef class.
   */
  private @Valid EntityRef entity;

  /**
   * Name given to this REST resource.
   */
  private @SafeText String name;
}