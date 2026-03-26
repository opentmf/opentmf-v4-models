package org.opentmf.tmf725.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttributeValueChangeEventBase;

/**
 * The notification data structure.
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
public class MetadataCategoryAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IMetadataCategoryAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid MetadataCategoryAttributeValueChangeEventPayload event;
}