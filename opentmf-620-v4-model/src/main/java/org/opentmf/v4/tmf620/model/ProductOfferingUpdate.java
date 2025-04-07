package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AgreementRef;
import org.opentmf.v4.common.model.AttachmentRefOrValue;
import org.opentmf.v4.common.model.CategoryRef;
import org.opentmf.v4.common.model.PlaceRef;
import org.opentmf.v4.common.model.ResourceCandidateRef;
import org.opentmf.v4.common.model.ServiceCandidateRef;
import org.opentmf.v4.common.model.TimePeriod;
import org.opentmf.v4.product.model.ProductSpecificationRef;

/**
 * Represents entities that are orderable from the provider of the catalog, this
 * resource includes pricing information.
 * <br/>Skipped properties: id,href,lastUpdate,{@literal @}type,{@literal @}baseType.
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
public class ProductOfferingUpdate {

  /**
   * Description of the productOffering.
   */
  private @SafeText String description;

  /**
   * isBundle determines whether a productOffering represents a single
   * productOffering (false), or a bundle of productOfferings (true).
   */
  private Boolean isBundle;

  /**
   * A flag indicating if this product offer can be sold stand-alone for sale or
   * not. If this flag is false it indicates that the offer can only be sold
   * within a bundle.
   */
  private Boolean isSellable;

  /**
   * Used to indicate the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name of the productOffering.
   */
  private @SafeText String name;

  /**
   * A string providing a complementary information on the value of the lifecycle
   * status attribute.
   */
  private @SafeText String statusReason;

  /**
   * ProductOffering version.
   */
  private @SafeText String version;

  /**
   * An agreement represents a contract or arrangement, either written or verbal
   * and sometimes enforceable by law, such as a service level agreement or a
   * customer price agreement. An agreement involves a number of other business
   * entities, such as products, services, and resources and/or their
   * specifications.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

  /**
   * Complements the description of an element (for instance a product) through
   * video, pictures...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * A type of ProductOffering that belongs to a grouping of ProductOfferings made
   * available to the market. It inherits of all attributes of ProductOffering.
   */
  @JsonProperty("bundledProductOffering")
  private List<@Valid BundledProductOffering> bundledProductOfferings;

  /**
   * The category resource is used to group product offerings, service and
   * resource candidates in logical containers. Categories can contain other
   * categories and/or product offerings, resource or service candidates.
   */
  @JsonProperty("category")
  private List<@Valid CategoryRef> categories;

  /**
   * The channel defines the channel for selling product offerings.
   */
  @JsonProperty("channel")
  private List<@Valid ChannelRef> channels;

  /**
   * provides references to the corresponding market segment as target of product
   * offerings. A market segment is grouping of Parties, GeographicAreas,
   * SalesChannels, and so forth.
   */
  @JsonProperty("marketSegment")
  private List<@Valid MarketSegmentRef> marketSegments;

  /**
   * Place defines the places where the products are sold or delivered.
   */
  @JsonProperty("place")
  private List<@Valid PlaceRef> places;

  /**
   * A use of the ProductSpecificationCharacteristicValue by a ProductOffering to
   * which additional properties (attributes) apply or override the properties of
   * similar properties contained in ProductSpecificationCharacteristicValue. It
   * should be noted that characteristics which their value(s) addressed by this
   * object must exist in corresponding product specification. The available
   * characteristic values for a ProductSpecificationCharacteristic in a Product
   * specification can be modified at the ProductOffering level. For example, a
   * characteristic 'Color' might have values White, Blue, Green, and Red. But,
   * the list of values can be restricted to e.g. White and Blue in an associated
   * product offering. It should be noted that the list of values in
   * 'ProductSpecificationCharacteristicValueUse' is a strict subset of the list
   * of values as defined in the corresponding product specification
   * characteristics.
   */
  @JsonProperty("prodSpecCharValueUse")
  private List<@Valid ProductSpecificationCharacteristicValueUse> prodSpecCharValueUses;

  /**
   * An amount, usually of money, that is asked for or allowed when a
   * ProductOffering is bought, rented, or leased. The price is valid for a
   * defined period of time and may not represent the actual price paid by a
   * customer.
   */
  @JsonProperty("productOfferingPrice")
  private List<@Valid ProductOfferingPriceRefOrValue> productOfferingPrices;

  /**
   * A relationship between this product offering and other product offerings.
   */
  @JsonProperty("productOfferingRelationship")
  private List<@Valid ProductOfferingRelationship> productOfferingRelationships;

  /**
   * A condition under which a ProductOffering is made available to Customers. For
   * instance, a productOffering can be offered with multiple commitment periods.
   */
  @JsonProperty("productOfferingTerm")
  private List<@Valid ProductOfferingTerm> productOfferingTerms;

  /**
   * A ProductSpecification is a detailed description of a tangible or intangible
   * object made available externally in the form of a ProductOffering to
   * customers or other parties playing a party role.
   */
  private @Valid ProductSpecificationRef productSpecification;

  /**
   * A resource candidate is an entity that makes a ResourceSpecification
   * available to a catalog.
   */
  private @Valid ResourceCandidateRef resourceCandidate;

  /**
   * ServiceCandidate is an entity that makes a ServiceSpecification available to
   * a catalog.
   */
  private @Valid ServiceCandidateRef serviceCandidate;

  /**
   * A service level agreement (SLA) is a type of agreement that represents a
   * formal negotiated agreement between two parties designed to create a common
   * understanding about products, services, priorities, responsibilities, and so
   * forth. The SLA is a set of appropriate procedures and targets formally or
   * informally agreed between parties in order to achieve and maintain specified
   * Quality of Service.
   */
  private @Valid SLARef serviceLevelAgreement;

  /**
   * The period for which the productOffering is valid.
   */
  private @Valid TimePeriod validFor;

  /**
   * A URI to a JSON-Schema file that defines additional attributes and
   * relationships.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;
}