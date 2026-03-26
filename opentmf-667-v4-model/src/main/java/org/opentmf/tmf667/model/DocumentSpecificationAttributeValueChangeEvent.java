package org.opentmf.tmf667.model;

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
 *   <li>TMF-667: Document Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class DocumentSpecificationAttributeValueChangeEvent extends AttributeValueChangeEventBase implements IDocumentSpecificationAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid DocumentSpecificationAttributeValueChangeEventPayload event;
}