package org.opentmf.v4.tmf620.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.common.model.EventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class ProductSpecificationCreateEvent extends EventBase {

  /**
   * The event payload linked to the involved resource object.
   */
  private @Valid ProductSpecificationCreateEventPayload event;
}