package org.opentmf.v4.tmf634.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.NamedEntity;

/**
 * A specification for an edge in a resource graph.
 *
 * <p><br/>
 * <strong>Required:</strong> associationType, endpointSpecification<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ConnectionSpecification.class
)
@Required(fields = {"endpointSpecification", "associationType"})
public class ConnectionSpecification extends NamedEntity {

  /**
   * Association type.
   */
  private @SafeText String associationType;

  /**
   * Specifications for resource graph vertices connected by this edge.
   */
  @JsonProperty("endpointSpecification")
  private @Size(min = 1) List<@Valid EndpointSpecificationRef> endpointSpecifications;
}