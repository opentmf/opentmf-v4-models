package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.EdgeRef;
import org.opentmf.general.model.EdgeBase;

/**
 * A Vertex is connected by directed Edges to other vertices in a Graph.
 * <br/>Skipped properties: id,href.
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
    defaultImpl = VertexUpdate.class
)
public class VertexUpdate extends EdgeBase implements IVertexUpdate {

  /**
   * Directed Edges which this Vertex is connected by. (optional, read only).
   */
  @JsonProperty("edge")
  private List<@Valid EdgeRef> edges;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("vertexCharacteristic")
  private List<@Valid Characteristic> vertexCharacteristics;

  /**
   * A Vertex is connected by directed Edges to other vertices in a Graph.
   * <br/>A VertexSpecification is a base class that represents a generic means
   * for implementing a particular type of Vertex. In essence, a
   * VertexSpecification defines the common attributes and relationships of a set
   * of related Vertices, while Vertex defines a specific instance that is based
   * on a particular VertexSpecification.
   */
  private @Valid VertexSpecificationRef vertexSpecification;
}