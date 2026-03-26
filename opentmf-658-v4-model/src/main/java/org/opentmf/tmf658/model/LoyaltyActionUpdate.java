package org.opentmf.tmf658.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Contains information on a loyalty action that should be applied should
 * certain conditions be met for a loyalty rule and program.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class LoyaltyActionUpdate implements ILoyaltyActionUpdate {

  /**
   * The HTTP operation to be used when calling the endpoint.
   */
  private @SafeText String action;

  private Object actionAttributes;

  /**
   * The type of loyalty action.
   */
  private @SafeText String actionType;

  private Object body;

  /**
   * A user-friendly identifier of the loyalty execution point.
   */
  private @SafeText String commonName;

  /**
   * A free-form description of the loyalty execution point.
   */
  private @SafeText String description;

  /**
   * The endpoint to call to trigger a BusinessInteraction, CustomerOrder or
   * LoyaltyEarn.
   */
  private @SafeText String endpoint;

  private Object headers;

  /**
   * Partnership reference. A partnership contains all the information for the
   * setup of a partnership of a given kind. This includes the list of identified
   * role types for the partnership with the corresponding agreement
   * specifications.
   */
  private @Valid PartnershipRef partnership;

  /**
   * ProductOffering reference. A product offering represents entities that are
   * orderable from the provider of the catalog, this resource includes pricing
   * information.
   */
  private @Valid ProductOfferingRef productOffering;

  /**
   * A string that identifies the version of the loyalty action.
   */
  private @SafeText String version;
}