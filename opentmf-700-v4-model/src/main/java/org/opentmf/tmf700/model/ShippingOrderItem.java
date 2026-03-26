package org.opentmf.tmf700.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.common.model.ProductPrice;
import org.opentmf.common.model.ProductRef;
import org.opentmf.common.model.RelatedPartyWithContactInfo;
import org.opentmf.common.model.RelatedPlaceRefOrValue;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.partner.model.ShippingInstruction;

/**
 * A list of shipping order items.
 *
 * <p><br/>
 * <strong>Required:</strong> action, id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-700: Shipping Order Management API</li>
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
    defaultImpl = ShippingOrderItem.class
)
@Required(fields = {"action", "id"})
public class ShippingOrderItem extends Entity implements IShippingOrderItem {

  /**
   * action to be performed on the shipping order item
   * <br/><p>Recommended values: add, modify, delete, noChange.
   *
   * @see org.opentmf.tmf700.model.ShippingOrderItemActionType
   */
  private @SafeText String action;

  /**
   * Related Entity reference. A related place defines a place described by
   * reference or by value linked to a specific entity. The polymorphic attributes
   * {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place entity and
   * not the RelatedPlaceRefOrValue class itself.
   */
  private @Valid RelatedPlaceRefOrValue placeFrom;

  /**
   * Related Entity reference. A related place defines a place described by
   * reference or by value linked to a specific entity. The polymorphic attributes
   * {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place entity and
   * not the RelatedPlaceRefOrValue class itself.
   */
  private @Valid RelatedPlaceRefOrValue placeTo;

  private @Valid ProductRef product;

  /**
   * ProductOffering reference. A product offering represents entities that are
   * orderable from the provider of the catalog, this resource includes pricing
   * information.
   */
  private @Valid ProductOfferingRef productOffering;

  /**
   * Reference to an order item that can typically be queried with another API.
   */
  private @Valid ProductOrderItemRef productOrderItem;

  /**
   * Quantity the individual shipment line item.
   */
  private @SafeText String quantity;

  /**
   * A party which is involved in this shipment and the role they are playing and
   * address. In case of shipping to addresses where a geo location is needed than
   * then PlaceTo,PlaceFrom can be used.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedPartyWithContactInfo> relatedParties;

  /**
   * A shipment defined by value or existing defined by reference. The polymorphic
   * attributes {@literal @}type, {@literal @}schemaLocation &amp; {@literal @}referredType are related to the
   * shipment entity and not the related ShipmentRefOrValue class itself.
   */
  private @Valid ShipmentRefOrValue shipment;

  /**
   * Instructions and details for the carrier.
   */
  private @Valid ShippingInstruction shippingInstruction;

  /**
   * ProductOffering reference. A product offering represents entities that are
   * orderable from the provider of the catalog, this resource includes pricing
   * information.
   */
  private @Valid ProductOfferingRef shippingOrderItemOffering;

  /**
   * An amount, usually of money, that represents the actual price paid by a
   * Customer for a purchase, a rent or a lease of a Product. The price is valid
   * for a defined period of time.
   */
  private @Valid ProductPrice shippingOrderItemPrice;

  /**
   * status of shipping order item. e.g. "active" , "savedForLater".
   */
  private @SafeText String status;
}