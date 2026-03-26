package org.opentmf.tmf679.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class ProductOfferingQualificationCreateEventPayload implements IProductOfferingQualificationCreateEventPayload {

  /**
   * ProductOfferingQualification is used to perform a commercial eligibility. It
   * allows to retrieve a list of productOffering that are commercially available
   * in the context of the interaction (defined be place, channel, party,
   * product).
   */
  private @Valid ProductOfferingQualification productOfferingQualification;
}