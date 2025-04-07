package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.common.model.NamedEntity;

/**
 * This represents a bundling pricing relationship, allowing a price to be
 * composed of multiple other prices (e.g. a recurring charge and a onetime
 * charge).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = BundledProductOfferingPriceRelationship.class
)
public class BundledProductOfferingPriceRelationship extends NamedEntity {
}