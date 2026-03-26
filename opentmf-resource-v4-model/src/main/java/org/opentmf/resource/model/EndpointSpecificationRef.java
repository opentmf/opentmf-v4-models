package org.opentmf.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

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
    defaultImpl = EndpointSpecificationRef.class
)
@Required(fields = {"id"})
public class EndpointSpecificationRef extends EntityRef implements IEndpointSpecificationRef {

  /**
   * Connection point specification reference. A connection point provides a
   * service access point (SAP) for input and/or output of the resource function.
   */
  private @Valid ConnectionPointSpecificationRef connectionPointSpecification;

  /**
   * Directionality: true when endpoint is a source, false when a sink. If true
   * for all endpoints connectivity is bidirectional. Default is true.
   */
  private Boolean isRoot;

  /**
   * Role of the Resource Function.
   */
  private @SafeText String role;
}