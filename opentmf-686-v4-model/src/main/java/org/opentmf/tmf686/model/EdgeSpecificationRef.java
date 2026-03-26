package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A directed Edge connects Vertices in a Graph.
 * <br/>An EdgeSpecification is a base class that represents a generic means for
 * implementing a particular type of Edge. In essence, an EdgeSpecification
 * defines the common attributes and relationships of a set of related Edges,
 * while Edge defines a specific instance that is based on a particular
 * EdgeSpecification.
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
    defaultImpl = EdgeSpecificationRef.class
)
@Required(fields = {"id"})
public class EdgeSpecificationRef extends EntityRef implements IEdgeSpecificationRef {

  /**
   * Edge Specification version.
   */
  private @SafeText String version;
}