package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
 *   <li>TMF-680: Recommendation Management API</li>
 *   <li>TMF-687: Stock Management API</li>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-703: Entity Inventory Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-717: Customer360 Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = MEntityBase.class
)
public abstract class MEntityBase extends NamedEntity implements IMEntityBase {

  /**
   * Is the description of the product. It could be copied from the description of
   * the Product Offering.
   */
  private @SafeText String description;

  /**
   * If true, the product is a ProductBundle which is an instantiation of a
   * BundledProductOffering. If false, the product is a ProductComponent which is
   * an instantiation of a SimpleProductOffering.
   */
  private Boolean isBundle;

  /**
   * Is the date from which the product starts.
   */
  private OffsetDateTime startDate;

  /**
   * Possible values for the status of the product
   * <br/><p>Recommended values: created, pendingActive, cancelled, active,
   * pendingTerminate, terminated, suspended, aborted.
   *
   * @see org.opentmf.common.model.ProductStatusType
   */
  private @SafeText String status;
}