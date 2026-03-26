package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A Vertex is connected by directed Edges to other vertices in a Graph.
 * <br/>A VertexSpecification is a base class that represents a generic means
 * for implementing a particular type of Vertex. In essence, a
 * VertexSpecification defines the common attributes and relationships of a set
 * of related Vertices, while Vertex defines a specific instance that is based
 * on a particular VertexSpecification.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-686: Topology API</li>
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
    defaultImpl = VertexSpecificationRef.class
)
@Required(fields = {"id"})
public class VertexSpecificationRef extends EntityRef implements IVertexSpecificationRef {

  /**
   * Vertex Specification version.
   */
  private @SafeText String version;
}