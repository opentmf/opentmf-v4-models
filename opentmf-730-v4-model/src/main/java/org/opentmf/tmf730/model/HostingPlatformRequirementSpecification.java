package org.opentmf.tmf730.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.resource.model.ResourceSpecification;

/**
 * This is a base class that is used to define the invariant characteristics and
 * behavior (attributes, constraints, and relationships) of a
 * HostingPlatformRequirement Resource.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = HostingPlatformRequirementSpecification.class
)
public class HostingPlatformRequirementSpecification extends ResourceSpecification implements IHostingPlatformRequirementSpecification {

  /**
   * True if the Capacity required can be virtualized.
   */
  private Boolean isVirtualizable;
}