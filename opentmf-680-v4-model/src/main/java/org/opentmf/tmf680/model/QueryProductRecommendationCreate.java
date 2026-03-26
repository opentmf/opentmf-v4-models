package org.opentmf.tmf680.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CategoryRef;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ProductOrderRef;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.RelatedPlaceRefOrValue;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.customer.model.RecommendationItem;
import org.opentmf.customer.model.ShoppingCartRef;

/**
 * Recommendation API is used to recommend offering quickly based on the history
 * and real-time context of customer. It is a real-time and personalized
 * recommendation API. It is usually provided by e-commerce or BSS, CRM system
 * in omni-channel.
 * <br/>Skipped properties: id,href,validFor,item.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-680: Recommendation Management API</li>
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
    defaultImpl = QueryProductRecommendationCreate.class
)
public class QueryProductRecommendationCreate extends Extensible implements IQueryProductRecommendationCreate {

  /**
   * List of: The category for grouping recommendations.
   */
  @JsonProperty("category")
  private List<@Valid CategoryRef> categories;

  /**
   * List of: The channel to which the resource reference to. e.g. channel for
   * selling product offerings, channel for opening a trouble ticket etc..
   */
  @JsonProperty("channel")
  private List<@Valid ChannelRef> channels;

  private @SafeText String description;

  /**
   * An indicator which when the value is "true" means that requester expects to
   * get recommendation result in the response.
   */
  private Boolean instantSyncRecommendation;

  /**
   * Name of the queryProductRecommendation.
   */
  private @SafeText String name;

  /**
   * Related Entity reference. A related place defines a place described by
   * reference or by value linked to a specific entity. The polymorphic attributes
   * {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place entity and
   * not the RelatedPlaceRefOrValue class itself.
   */
  private @Valid RelatedPlaceRefOrValue place;

  /**
   * List of: ProductOrder (ProductOrder) .The product order which the
   * recommendation is related with.
   */
  @JsonProperty("productOrder")
  private List<@Valid ProductOrderRef> productOrders;

  /**
   * List of: Describes a specific item contained in a parent element.
   */
  @JsonProperty("productOrderItem")
  private List<@Valid ItemRef> productOrderItems;

  /**
   * List of: A list of recommendation items. Every item is a product offering and
   * its rank.
   */
  @JsonProperty("recommendationItem")
  private List<@Valid RecommendationItem> recommendationItems;

  /**
   * The type of the queryProductRecommendation.
   */
  private @SafeText String recommendationType;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  private @Valid RelatedParty relatedParty;

  /**
   * List of: ShoppingCart (ShoppingCartRef) . The shopping cart which the
   * recommendation is related with.
   */
  @JsonProperty("shoppingCart")
  private List<@Valid ShoppingCartRef> shoppingCarts;

  /**
   * List of: Describes a specific item contained in a parent element.
   */
  @JsonProperty("shoppingCartItem")
  private List<@Valid ItemRef> shoppingCartItems;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}