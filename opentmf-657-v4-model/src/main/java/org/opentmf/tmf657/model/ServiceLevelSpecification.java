package org.opentmf.tmf657.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A Service Level Specification represents a pre-defined or negotiated set of
 * Service Level 
 * <br/>Objectives. In addition, certain consequences are associated with not
 * meeting the Service Level 
 * <br/>Objectives. Service Level Agreements are expressed in terms of Service
 * Level Specifications.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-657: Service Quality Management Management API</li>
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
    defaultImpl = ServiceLevelSpecification.class
)
public class ServiceLevelSpecification extends ServiceLevelSpecificationCreate implements IServiceLevelSpecification {

  /**
   * The hyperlink to access a service level specification.
   */
  private URI href;

  /**
   * The identifier to a service level specification.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}