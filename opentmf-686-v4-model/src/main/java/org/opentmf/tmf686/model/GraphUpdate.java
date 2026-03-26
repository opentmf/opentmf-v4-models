package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Graph is a directed graph representing edges connecting vertices.
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
    defaultImpl = GraphUpdate.class
)
public class GraphUpdate extends Extensible implements IGraphUpdate {

  /**
   * Description of this REST resource.
   */
  private @SafeText String description;

  /**
   * Graph edge collection reference.
   */
  private @Valid EdgeCollectionRef edge;

  /**
   * Relationship to another Graph.
   */
  @JsonProperty("graphRelationship")
  private List<@Valid GraphRelationship> graphRelationships;

  /**
   * Name given to this REST resource.
   */
  private @SafeText String name;

  /**
   * Graph vertex collection reference.
   */
  private @Valid VertexCollectionRef vertex;
}