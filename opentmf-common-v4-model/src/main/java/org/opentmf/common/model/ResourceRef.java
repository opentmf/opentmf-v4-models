package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
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
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-640: Service Activation Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-645: Service Qualification Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-649: Performance Thresholding Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-677: Usage Consumption Management API</li>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
 *   <li>TMF-680: Recommendation Management API</li>
 *   <li>TMF-687: Stock Management API</li>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-716: ResourceReservation</li>
 *   <li>TMF-717: Customer360 Management API</li>
 *   <li>TMF-720: Digital Identity Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
 *   <li>TMF-915: AI Management API</li>
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
    defaultImpl = ResourceRef.class
)
@Required(fields = {"id"})
public class ResourceRef extends EntityRef implements IResourceRef {

  /**
   * The resource value that can be used to identify a resource with a public key
   * (e.g.: a tel nr, an msisdn).
   */
  private @SafeText String value;
}