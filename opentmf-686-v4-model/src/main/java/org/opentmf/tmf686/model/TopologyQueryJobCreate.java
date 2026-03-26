package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Represents a task used to query topology in the service
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> graphSource<br/>
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
    defaultImpl = TopologyQueryJobCreate.class
)
@Required(fields = {"graphSource"})
public class TopologyQueryJobCreate extends TopologyDiscoveryJobUpdate implements ITopologyQueryJobCreate {

  /**
   * The topology graph(s) created by the query.
   */
  @JsonProperty("graphResult")
  private List<@Valid GraphRef> graphResults;

  private @Valid GraphRef graphSource;

  /**
   * Graph is a directed graph representing edges connecting vertices.
   */
  private @Valid Graph graphTemplate;

  /**
   * Pattern to search for in graph.
   */
  @JsonProperty("queryMatch")
  private List<@Valid JSONPathQueryJsonLdExpression> queryMatches;

  /**
   * The vertices result of the query.
   */
  @JsonProperty("vertexResult")
  private List<@Valid VertexRef> vertexResults;
}