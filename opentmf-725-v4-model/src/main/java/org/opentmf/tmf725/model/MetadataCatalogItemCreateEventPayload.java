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
public class MetadataCatalogItemCreateEventPayload implements IMetadataCatalogItemCreateEventPayload {

  /**
   * An MetadataCatalogItem is an entity that allows any metadata asset or even
   * any object inheriting from RootEntity, to be available to a catalog. The
   * MetadataSpecification and Policy of the catalog governs the content of the
   * MetadataCatalogItem. This API addresses only MetadataSpecification items
   * extended from RootEntity as MetadataCatalogItem.
   * <br/>The MetadataCatalogItem resource (JSON format) represents a set of
   * characteristics that define the values given by the MetadataCatalogItem.
   */
  private @Valid MetadataCatalogItem metadataCatalogItem;
}