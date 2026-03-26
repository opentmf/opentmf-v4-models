package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * ProductOrder (ProductOrder) .The product order which the recommendation is
 * related with.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-680: Recommendation Management API</li>
 *   <li>TMF-696: Risk Management API</li>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-717: Customer360 Management API</li>
 *   <li>TMF-728: Dunning Case Management</li>
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
    defaultImpl = ProductOrderRef.class
)
@Required(fields = {"id"})
public class ProductOrderRef extends EntityRef implements IProductOrderRef {
}