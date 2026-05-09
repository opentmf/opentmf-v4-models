package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.GraphRef;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 6 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>EdgeCreate (686)</li>
 *   <li>EdgeUpdate (686)</li>
 *   <li>VertexCreate (686)</li>
 *   <li>VertexUpdate (686)</li>
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
    defaultImpl = EdgeBase.class
)
public abstract class EdgeBase extends Extensible implements IEdgeBase {

  /**
   * Description of this REST resource.
   */
  private @SafeText String description;

  /**
   * Entity reference schema to be used for all entityRef class.
   */
  private @Valid EntityRef entity;

  private @Valid GraphRef graph;

  /**
   * Name given to this REST resource.
   */
  private @SafeText String name;

  private @Valid GraphRef subGraph;
}