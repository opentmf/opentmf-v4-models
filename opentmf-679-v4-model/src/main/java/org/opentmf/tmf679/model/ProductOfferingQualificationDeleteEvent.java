package org.opentmf.tmf679.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AddressableEventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ProductOfferingQualificationDeleteEvent extends AddressableEventBase implements IProductOfferingQualificationDeleteEvent {

  /**
   * The event data structure.
   */
  private @Valid ProductOfferingQualificationDeleteEventPayload event;
}