package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A Vertex is connected by directed Edges to other vertices in a Graph.
 * <br/>A VertexSpecification is a base class that represents a generic means
 * for implementing a particular type of Vertex. In essence, a
 * VertexSpecification defines the common attributes and relationships of a set
 * of related Vertices, while Vertex defines a specific instance that is based
 * on a particular VertexSpecification.
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
    defaultImpl = VertexSpecification.class
)
public class VertexSpecification extends VertexSpecificationUpdate implements IVertexSpecification {

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * unique identifier.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}