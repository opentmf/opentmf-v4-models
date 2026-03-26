package org.opentmf.tmf703.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-703: Entity Inventory Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class EntityDeleteEventPayload implements IEntityDeleteEventPayload {

  /**
   * Base entity schema for use in TMForum Open-APIs.
   */
  private @Valid Entity entity;
}