package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.RelatedEntityRefOrValue;

/**
 * Describes a non-composite relationship between product offering prices. For
 * example one price might be an discount alteration for another price.
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
    defaultImpl = ProductOfferingPriceRelationship.class
)
public class ProductOfferingPriceRelationship extends RelatedEntityRefOrValue {

  /**
   * type of the relationship, for example override, discount, etc.
   */
  private @SafeText String relationshipType;
}