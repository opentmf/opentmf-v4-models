package org.opentmf.resource.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Resource;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ResourceAttributeValueChangeEventPayload implements IResourceAttributeValueChangeEventPayload {

  /**
   * Resource is an abstract entity that describes the common set of attributes
   * shared by all concrete resources (e.g. TPE, EQUIPMENT) in the inventory.
   */
  private @Valid Resource resource;
}