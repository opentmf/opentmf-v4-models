package org.opentmf.v4.tmf634.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class ResourceCatalogCreateEventPayload {

  /**
   * The involved resource data for the event.
   */
  private @Valid ResourceCatalog resourceCatalog;
}