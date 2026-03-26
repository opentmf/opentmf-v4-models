package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.general.model.EdgeCreateBase;

/**
 * Edge is a directed edge connecting vertices in a directed Graph.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> graph, name<br/>
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
    defaultImpl = EdgeCreate.class
)
@Required(fields = {"name", "graph"})
public class EdgeCreate extends EdgeCreateBase implements IEdgeCreate {

  /**
   * Indicates if this Edge is birectional (true) or unidirection originating from
   * the first vertex (false).
   */
  private Boolean bidirectional;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("edgeCharacteristic")
  private List<@Valid Characteristic> edgeCharacteristics;

  /**
   * A directed Edge connects Vertices in a Graph.
   * <br/>An EdgeSpecification is a base class that represents a generic means for
   * implementing a particular type of Edge. In essence, an EdgeSpecification
   * defines the common attributes and relationships of a set of related Edges,
   * while Edge defines a specific instance that is based on a particular
   * EdgeSpecification.
   */
  private @Valid EdgeSpecificationRef edgeSpecification;

  private @Valid GraphRef graph;

  private @Valid GraphRef subGraph;

  /**
   * Graph Vertices connected by this Edge.
   */
  @JsonProperty("vertex")
  private List<@Valid VertexRef> vertexes;
}