package org.opentmf.partner.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ExternalIdentifier;
import org.opentmf.common.model.Price;
import org.opentmf.common.model.ProductRefOrValue;
import org.opentmf.common.model.ProductStockRef;
import org.opentmf.common.model.Quantity;
import org.opentmf.common.model.ReserveProductStockRef;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
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
    defaultImpl = ShipmentItem.class
)
public class ShipmentItem extends Extensible implements IShipmentItem {

  /**
   * action to be performed on the shipment item
   * <br/><p>Recommended values: add, modify, delete, noChange.
   *
   * @see org.opentmf.partner.model.ShipmentItemActionType
   */
  private @SafeText String action;

  /**
   * List of characteristics with values that define the test run.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

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
  private List<@Valid ExternalIdentifier> externalIdentifiers;

  /**
   * Identifier of the individual shipment line item.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * A product to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the product entity and not the RelatedProductRefOrValue class itself.
   */
  private @Valid ProductRefOrValue product;

  /**
   * Product Stock Reservation reference.
   */
  private @Valid ReserveProductStockRef productReservationRef;

  /**
   * ProductStockRef is a reference to a product stock.
   */
  private @Valid ProductStockRef productStockRef;

  /**
   * Quantity the individual shipment line item.
   */
  private @SafeText String quantity;

  /**
   * Provides all amounts (tax included, duty free, tax rate), used currency and
   * percentage to apply for Price Alteration.
   */
  private @Valid Price shipmentItemPrice;

  /**
   * SKU (Stock Keeping Unit) is a unique code that you use to identify every
   * inventory item in your warehouse.
   */
  private @SafeText String sku;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity weight;
}