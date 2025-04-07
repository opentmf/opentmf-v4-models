package org.opentmf.v4.tmf634.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Specifies a function as a behavior to transform inputs of any nature into
 * outputs of any nature independently from the way it is provided, for example
 * a Medium to Large Enterprise Firewall.
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
    defaultImpl = ResourceFunctionSpecification.class
)
public class ResourceFunctionSpecification extends LogicalResourceSpecification {

  /**
   * External connection point specifications. These are the service access points
   * (SAP) where inputs and outputs of the function are available.
   */
  @JsonProperty("connectionPointSpecification")
  private List<@Valid ConnectionPointSpecificationRef> connectionPointSpecifications;

  /**
   * Internal connectivity potential specifications.
   */
  @JsonProperty("connectivitySpecification")
  private List<@Valid ResourceGraphSpecification> connectivitySpecifications;
}