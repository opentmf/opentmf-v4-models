package org.opentmf.v4.tmf634.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * This is an example of a derived class of ResourceSpecification, and is used
 * to define the invariant characteristics and behavior (attributes, methods,
 * constraints, and relationships) of a LogicalResource.
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
    defaultImpl = LogicalResourceSpecification.class
)
public class LogicalResourceSpecification extends ResourceSpecificationCreate {

  /**
   * unique identifier.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Hyperlink reference.
   */
  private URI href;
}