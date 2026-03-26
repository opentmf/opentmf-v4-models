package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Agreement reference. An agreement represents a contract or arrangement,
 * either written or verbal and sometimes enforceable by law, such as a service
 * level agreement or a customer price agreement. An agreement involves a number
 * of other business entities, such as products, services, and resources and/or
 * their specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
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
    defaultImpl = AgreementItemRef.class
)
@Required(fields = {"id"})
public class AgreementItemRef extends EntityRef implements IAgreementItemRef {

  /**
   * Identifier of the agreement.
   */
  @SafeId
  @Size(max = 100)
  private String agreementItemId;
}