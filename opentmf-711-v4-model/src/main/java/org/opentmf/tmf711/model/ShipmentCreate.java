package org.opentmf.tmf711.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ExternalReference;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.PaymentMethodRef;
import org.opentmf.common.model.Price;
import org.opentmf.common.model.Quantity;
import org.opentmf.common.model.RelatedPartyWithContactInfo;
import org.opentmf.common.model.RelatedPlaceRefOrValue;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.partner.model.RelatedShipment;
import org.opentmf.partner.model.ShipmentItem;
import org.opentmf.partner.model.ShipmentSpecificationRefOrValue;
import org.opentmf.partner.model.ShipmentTrackingRef;
import org.opentmf.partner.model.ShippingInstruction;

/**
 * Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = ShipmentCreate.class
)
public class ShipmentCreate extends Extensible implements IShipmentCreate {

  /**
   * List of characteristics with values.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * The date the package was collected from the carrier (Collection scenario).
   */
  private OffsetDateTime collectionDate;

  /**
   * Effective delivery date amended by the provider.
   */
  private OffsetDateTime completionDate;

  /**
   * Is the date at which the shipment was completed (customer has taken ownership
   * of the package).
   */
  private OffsetDateTime deliveryDate;

  /**
   * Description of the shipment. It could be the same as the description of the
   * shipment specification.
   */
  private @SafeText String description;

  /**
   * The date that the shipment will be delivered.
   */
  private OffsetDateTime expectedDeliveryDate;

  /**
   * An identification of an entity that is owned by or originates in a software
   * system different from the current system, for example a ProductOrder handed
   * off from a commerce platform into an order handling system. The structure
   * identifies the system itself, the nature of the entity within the system
   * (e.g. class name) and the unique ID of the entity within the system. It is
   * anticipated that multiple external IDs can be held for a single entity, e.g.
   * if the entity passed through multiple systems on the way to the current
   * system. In this case the consumer is expected to sequence the IDs in the
   * array in reverse order of provenance, i.e. most recent system first in the
   * list.
   */
  @JsonProperty("externalIdentifier")
  private List<@Valid ExternalReference> externalIdentifiers;

  /**
   * Name of the shipment. It could be the same as the name of the shipment
   * specification.
   */
  private @SafeText String name;

  /**
   * A list of notes made on this shipment.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * PaymentMethod reference. A payment method defines a specific mean of payment
   * (e.g. direct debit).
   */
  private @Valid PaymentMethodRef paymentMethod;

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
   * A list of parties which are involved in this shipment and the role they are
   * playing.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedPartyWithContactInfo> relatedParties;

  /**
   * A related shipment addressable entity.
   */
  private @Valid RelatedShipment relatedShipment;

  /**
   * The date requester by the sender for shipment delivery.
   */
  private OffsetDateTime requestedDeliveryDate;

  /**
   * List of items that are part of the shipment (parcel/package).
   */
  @JsonProperty("shipmentItem")
  private List<@Valid ShipmentItem> shipmentItems;

  /**
   * Provides all amounts (tax included, duty free, tax rate), used currency and
   * percentage to apply for Price Alteration.
   */
  private @Valid Price shipmentPrice;

  /**
   * A shipment specification defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation &amp; {@literal @}referredType are
   * related to the shipment specification entity and not the related
   * ShipmentSpecificationRefOrValue class itself.
   */
  private @Valid ShipmentSpecificationRefOrValue shipmentSpecification;

  /**
   * ShipmentTracking reference.
   */
  private @Valid ShipmentTrackingRef shipmentTracking;

  /**
   * Instructions and details for the carrier.
   */
  private @Valid ShippingInstruction shippingInstruction;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity weight;
}