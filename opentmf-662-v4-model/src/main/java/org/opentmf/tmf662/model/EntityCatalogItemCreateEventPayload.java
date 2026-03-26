package org.opentmf.tmf662.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-662: Entity Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class EntityCatalogItemCreateEventPayload implements IEntityCatalogItemCreateEventPayload {

  /**
   * An EntityCatalogItem is an entity that allows any ProductOffering,
   * ServiceCandidate, ResourceCandidate, or even any object inheriting from
   * RootEntity, to be available to a catalog. The CatalogSpecification and Policy
   * of the catalog governs the content of the EntityCatalogItem. This API
   * addresses only EntitySpecification items extended from RootEntity as
   * EntityCatalogItem.
   * <br/>The EntityCatalogItem resource (JSON format) represents a set of
   * characteristics that define the values given by the EntityCatalogItem.
   */
  private @Valid EntityCatalogItem entityCatalogItem;
}