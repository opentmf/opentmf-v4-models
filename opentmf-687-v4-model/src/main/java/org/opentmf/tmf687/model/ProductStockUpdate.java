package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.MarketSegmentRef;
import org.opentmf.common.model.ProductRefOrValue;
import org.opentmf.common.model.Quantity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.RelatedPlaceRefOrValue;
import org.opentmf.common.model.ResourceRef;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * ProductStock is a base class for defining a product (or configured product
 * with values characteristic) stock level.
 * <br/>Skipped properties: id,href,creationDate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-687: Stock Management API</li>
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
    defaultImpl = ProductStockUpdate.class
)
public class ProductStockUpdate extends Extensible implements IProductStockUpdate {

  /**
   * List of: The channel to which the resource reference to. e.g. channel for
   * selling product offerings, channel for opening a trouble ticket etc..
   */
  @JsonProperty("channel")
  private List<@Valid ChannelRef> channels;

  /**
   * Free-text description of the ProductStock.
   */
  private @SafeText String description;

  /**
   * Last inventory count date for this ProductStock.
   */
  private OffsetDateTime lastInventoryDate;

  /**
   * Last date when the ProductStock record was updated.
   */
  private OffsetDateTime lastUpdate;

  /**
   * provides references to the corresponding market segment as target of a
   * product stock. A market segment is grouping of Parties, GeographicAreas,
   * SalesChannels, and so forth.
   */
  @JsonProperty("marketSegment")
  private List<@Valid MarketSegmentRef> marketSegments;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity maxStockLevel;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity minStockLevel;

  /**
   * Name of the ProductStock.
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
   * An amount in a given unit.
   */
  private @Valid Quantity productStockLevel;

  /**
   * relationship to other product stock.
   */
  @JsonProperty("productStockRelationship")
  private List<@Valid ProductStockRelationship> productStockRelationships;

  /**
   * Possible values for the status of the stock level
   * <br/><p>Recommended values: reserved, available, unavailable, unknown.
   *
   * @see org.opentmf.tmf687.model.ProductStockStatusType
   */
  private @SafeText String productStockStatusType;

  /**
   * Possible values for the usage of the stock level - This is illustrative
   * <br/><p>Recommended values: inTransit, onDisplay, damaged, returned,
   * replenishmentInProgress, inShop.
   *
   * @see org.opentmf.tmf687.model.ProductStockUsageType
   */
  private @SafeText String productStockUsageType;

  /**
   * A list of related party references (RelatedParty [*]). A related party
   * defines party or party role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity reorderQuantity;

  /**
   * Planned date for future replenishment for this ProductStock.
   */
  private OffsetDateTime replenishmentDate;

  /**
   * The Resource managed through this ProductStock is used.
   */
  @JsonProperty("resource")
  private List<@Valid ResourceRef> resources;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity stockLevelAlert;

  /**
   * Category of the ProductStock.
   */
  private @SafeText String stockLevelCategory;

  /**
   * A product to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the product entity and not the RelatedProductRefOrValue class itself.
   */
  private @Valid ProductRefOrValue stockedProduct;
}