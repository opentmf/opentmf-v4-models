package org.opentmf.v4.tmf639.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.resource.model.Resource;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class ResourceAttributeValueChangeEventPayload {

  /**
   * The involved resource data for the event.
   */
  private @Valid Resource resource;
}