package org.opentmf.v4.tmf634.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.EntityRef;

/**
 * A specification for a vertex in a resource graph.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
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
    defaultImpl = EndpointSpecificationRef.class
)
@Required(fields = {"id"})
public class EndpointSpecificationRef extends EntityRef {

  /**
   * Directionality: true when endpoint is a source, false when a sink. If true
   * for all endpoints connectivity is bidirectional. Default is true.
   */
  private Boolean isRoot;

  /**
   * Role of the Resource Function.
   */
  private @SafeText String role;

  /**
   * A specification for the connection point (SAP) of the associated resource
   * function (optional).
   */
  private @Valid ConnectionPointSpecificationRef connectionPointSpecification;
}