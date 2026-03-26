package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A directed Edge connects Vertices in a Graph.
 * <br/>An EdgeSpecification is a base class that represents a generic means for
 * implementing a particular type of Edge. In essence, an EdgeSpecification
 * defines the common attributes and relationships of a set of related Edges,
 * while Edge defines a specific instance that is based on a particular
 * EdgeSpecification.
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
    defaultImpl = EdgeSpecification.class
)
public class EdgeSpecification extends EdgeSpecificationUpdate implements IEdgeSpecification {

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