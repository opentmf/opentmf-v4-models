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
public class EntityCategoryDeleteEventPayload implements IEntityCategoryDeleteEventPayload {

  /**
   * The (entity) category resource is used to group entity catalog items in
   * logical containers. Categories can contain other categories.
   * <br/>Resource IDs for categories are strings and are defined by the catalog
   * application.
   */
  private @Valid EntityCategory entityCategory;
}