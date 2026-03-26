package org.opentmf.tmf725.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-725: Metadata Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class MetadataCategoryAttributeValueChangeEventPayload implements IMetadataCategoryAttributeValueChangeEventPayload {

  /**
   * The category resource is used to group metadata catalog items in logical
   * containers. Categories can contain other categories.
   * <br/>Resource IDs for categories are strings and are defined by the catalog
   * application.
   */
  private @Valid MetadataCategory metadataCategory;
}