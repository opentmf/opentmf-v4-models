package org.opentmf.customer.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.common.model.ProductRefOrValue;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A list of recommendation items. Every item is a product offering and its
 * rank.
 *
 * <p><br/>
 * <strong>Required:</strong> product<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-680: Recommendation Management API</li>
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
    defaultImpl = RecommendationItem.class
)
@Required(fields = {"product"})
public class RecommendationItem extends Entity implements IRecommendationItem {

  /**
   * The rank of the list of recommended offering.
   */
  private Integer priority;

  /**
   * A product to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the product entity and not the RelatedProductRefOrValue class itself.
   */
  private @Valid ProductRefOrValue product;

  /**
   * ProductOffering reference. A product offering represents entities that are
   * orderable from the provider of the catalog, this resource includes pricing
   * information.
   */
  private @Valid ProductOfferingRef productOffering;
}