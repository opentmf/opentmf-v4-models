package org.opentmf.tmf700.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.common.model.ProductOrderRef;
import org.opentmf.common.model.ProductPrice;
import org.opentmf.common.model.RelatedPartyWithContactInfo;
import org.opentmf.common.model.RelatedPlaceRefOrValue;
import org.opentmf.common.model.RelatedShippingOrder;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.partner.model.ShippingInstruction;

/**
 * A Shipping Order is a document used by a business to specify what items are
 * to be transferred from a storage location or warehouse to which person and to
 * which new location. A Shipping Order can typically be sent along with a
 * shipment of goods so that the person receiving them can verify that the
 * document correctly reflects the items that they actually received.
 * <br/>Skipped properties: id,href,creationDate,lastUpdateDate.
 *
 * <p><br/>
 * <strong>Required:</strong> shippingOrderItem<br/>
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
    defaultImpl = ShippingOrderCreate.class
)
@Required(fields = {"shippingOrderItem"})
public class ShippingOrderCreate extends Extensible implements IShippingOrderCreate {

  /**
   * A list of notes made on this shipping shipment.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

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

  /**
   * ProductOrder (ProductOrder) .The product order which the recommendation is
   * related with.
   */
  private @Valid ProductOrderRef productOrder;

  /**
   * An existing related party that has some form of correlation with the given
   * shipping order. It can be recipient, payer, etc.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedPartyWithContactInfo> relatedParties;

  /**
   * A related shipping order addressable entity.
   */
  private @Valid RelatedShippingOrder relatedShippingOrder;

  /**
   * Instructions and details for the carrier.
   */
  private @Valid ShippingInstruction shippingInstruction;

  /**
   * List of characteristics with values.
   */
  @JsonProperty("shippingOrderCharacteristic")
  private List<@Valid Characteristic> shippingOrderCharacteristics;

  /**
   * A list of shipping order items. Each shipping order item has a corresponding
   * Shipment(e.g. parcel) which has one or multiple products in it.
   */
  @JsonProperty("shippingOrderItem")
  private @Size(min = 1) List<@Valid ShippingOrderItem> shippingOrderItems;

  /**
   * ProductOffering reference. A product offering represents entities that are
   * orderable from the provider of the catalog, this resource includes pricing
   * information.
   */
  private @Valid ProductOfferingRef shippingOrderOffering;

  /**
   * An amount, usually of money, that represents the actual price paid by a
   * Customer for a purchase, a rent or a lease of a Product. The price is valid
   * for a defined period of time.
   */
  private @Valid ProductPrice shippingOrderPrice;

  /**
   * status of shipping order e.g. "active" , "savedForLater".
   */
  private @SafeText String status;
}