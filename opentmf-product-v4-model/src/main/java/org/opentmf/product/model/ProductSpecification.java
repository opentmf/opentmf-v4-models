package org.opentmf.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.ResourceSpecificationRef;
import org.opentmf.common.model.ServiceSpecificationRef;
import org.opentmf.common.model.TargetProductSchema;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Is a detailed description of a tangible or intangible object made available
 * externally in the form of a ProductOffering to customers or other parties
 * playing a party role.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = ProductSpecification.class
)
public class ProductSpecification extends BundledProductSpecification implements IProductSpecification {

  /**
   * Complements the description of an element (for instance a product) through
   * video, pictures...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * The manufacturer or trademark of the specification.
   */
  private @SafeText String brand;

  /**
   * A type of ProductSpecification that belongs to a grouping of
   * ProductSpecifications made available to the market. It inherits of all
   * attributes of ProductSpecification.
   */
  @JsonProperty("bundledProductSpecification")
  private List<@Valid BundledProductSpecification> bundledProductSpecifications;

  /**
   * A narrative that explains in detail what the product specification is.
   */
  private @SafeText String description;

  /**
   * isBundle determines whether a productSpecification represents a single
   * productSpecification (false), or a bundle of productSpecification (true).
   */
  private Boolean isBundle;

  /**
   * Date and time of the last update.
   */
  private OffsetDateTime lastUpdate;

  /**
   * An identification number assigned to uniquely identity the specification.
   */
  private @SafeText String productNumber;

  /**
   * A characteristic quality or distinctive feature of a ProductSpecification.
   * The characteristic can be take on a discrete value, such as color, can take
   * on a range of values, (for example, sensitivity of 100-240 mV), or can be
   * derived from a formula (for example, usage time (hrs) = 30 - talk time *3).
   * Certain characteristics, such as color, may be configured during the ordering
   * or some other process.
   */
  @JsonProperty("productSpecCharacteristic")
  private List<@Valid ProductSpecificationCharacteristic> productSpecCharacteristics;

  /**
   * A migration, substitution, dependency or exclusivity relationship
   * between/among product specifications.
   */
  @JsonProperty("productSpecificationRelationship")
  private List<@Valid ProductSpecificationRelationship> productSpecificationRelationships;

  /**
   * A related party defines party or party role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * The ResourceSpecification is required to realize a ProductSpecification.
   */
  @JsonProperty("resourceSpecification")
  private List<@Valid ResourceSpecificationRef> resourceSpecifications;

  /**
   * ServiceSpecification(s) required to realize a ProductSpecification.
   */
  @JsonProperty("serviceSpecification")
  private List<@Valid ServiceSpecificationRef> serviceSpecifications;

  /**
   * The reference object to the schema and type of target product which is
   * described by product specification.
   */
  private @Valid TargetProductSchema targetProductSchema;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * Product specification version.
   */
  private @SafeText String version;
}