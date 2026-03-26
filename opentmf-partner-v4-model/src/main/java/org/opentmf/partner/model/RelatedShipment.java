package org.opentmf.partner.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.RelatedEntityRefOrValue;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A related shipment addressable entity.
 *
 * <p><br/>
 * <strong>Required:</strong> role<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
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
    defaultImpl = RelatedShipment.class
)
@Required(fields = {"role"})
public class RelatedShipment extends RelatedEntityRefOrValue implements IRelatedShipment {
}