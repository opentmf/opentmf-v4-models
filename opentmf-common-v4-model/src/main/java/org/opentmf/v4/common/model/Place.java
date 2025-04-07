package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Place reference. Place defines the places where the products are sold or
 * delivered.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-673: Geographic Address Management API</li>
 *   <li>TMF-674: Geographic Site Management API</li>
 *   <li>TMF-675: Geographic Location API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = Place.class
)
public class Place extends EntityRefOrValue {
}