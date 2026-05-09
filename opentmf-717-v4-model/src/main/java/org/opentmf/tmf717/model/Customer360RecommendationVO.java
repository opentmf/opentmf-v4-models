package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CategoryRef;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.GeographicLocationRef;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.ProductOrderRef;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.ShoppingCartRef;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.customer.model.RecommendationItem;

/**
 * Recommendation API is used to recommend offering quickly based on the history
 * and real-time context of customer. It is a real-time and personalized
 * recommendation API. It is usually provided by e-commerce or BSS, CRM system
 * in omni-channel.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = Customer360RecommendationVO.class
)
public class Customer360RecommendationVO extends NamedEntity implements ICustomer360RecommendationVO {

  /**
   * The category for grouping recommendations.
   */
  private @Valid CategoryRef category;

  /**
   * The channel to which the resource reference to. e.g. channel for selling
   * product offerings, channel for opening a trouble ticket etc..
   */
  private @Valid ChannelRef channel;

  private @SafeText String description;

  /**
   * List of: A list of recommendation items. Every item is a product offering and
   * its rank.
   */
  @JsonProperty("item")
  private List<@Valid RecommendationItem> items;

  private @Valid GeographicLocationRef location;

  /**
   * ProductOrder (ProductOrder) .The product order which the recommendation is
   * related with.
   */
  private @Valid ProductOrderRef order;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  private @Valid RelatedParty party;

  /**
   * The type of recommendation.
   */
  private @SafeText String recommendationType;

  /**
   * ShoppingCart (ShoppingCartRef) . The shopping cart which the recommendation
   * is related with.
   */
  private @Valid ShoppingCartRef shoppingCart;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}