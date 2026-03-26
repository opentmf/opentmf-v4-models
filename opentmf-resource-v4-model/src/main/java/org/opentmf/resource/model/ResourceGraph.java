package org.opentmf.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Resource graph.
 *
 * <p><br/>
 * <strong>Required:</strong> connection<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
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
    defaultImpl = ResourceGraph.class
)
@Required(fields = {"connection"})
public class ResourceGraph extends NamedEntity implements IResourceGraph {

  /**
   * Resource graph edges.
   */
  @JsonProperty("connection")
  private @Size(min = 1) List<@Valid Connection> connections;

  /**
   * Description of the resource graph.
   */
  private @SafeText String description;

  /**
   * Relationships to other resource graphs.
   */
  @JsonProperty("graphRelationship")
  private List<@Valid ResourceGraphRelationship> graphRelationships;
}