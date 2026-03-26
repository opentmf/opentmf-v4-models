package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AssociationCreateBase;
import org.opentmf.common.model.RelatedParty;

/**
 * A Vertex is connected by directed Edges to other vertices in a Graph.
 * <br/>A VertexSpecification is a base class that represents a generic means
 * for implementing a particular type of Vertex. In essence, a
 * VertexSpecification defines the common attributes and relationships of a set
 * of related Vertices, while Vertex defines a specific instance that is based
 * on a particular VertexSpecification.
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
    defaultImpl = VertexSpecificationUpdate.class
)
public class VertexSpecificationUpdate extends AssociationCreateBase implements IVertexSpecificationUpdate {

  /**
   * A related party defines party or party role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A characteristic quality or distinctive feature of a VertexSpecification.
   */
  @JsonProperty("vertexSpecCharacteristic")
  private List<@Valid VertexSpecificationCharacteristic> vertexSpecCharacteristics;
}