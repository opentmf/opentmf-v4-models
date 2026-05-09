package org.opentmf.tmf715.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AgreementSpecification;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.ProductSpecificationRef;
import org.opentmf.common.model.Quantity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.ResourceSpecificationRef;
import org.opentmf.common.model.WarrantySpecificationRelationship;
import org.opentmf.common.model.WorkSpecificationUpdateBase;

/**
 * Skipped properties: id,href,lastUpdate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-715: Warranty Management</li>
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
    defaultImpl = WarrantySpecificationUpdate.class
)
public class WarrantySpecificationUpdate extends WorkSpecificationUpdateBase implements IWarrantySpecificationUpdate {

  /**
   * Attachments that may be of relevance to this specification, such as picture,
   * document, media.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * List of: Product specification reference: A ProductSpecification is a
   * detailed description of a tangible or intangible object made available
   * externally in the form of a ProductOffering to customers or other parties
   * playing a party role.
   */
  @JsonProperty("productSpec")
  private List<@Valid ProductSpecificationRef> productSpecs;

  /**
   * Parties who manage or otherwise have an interest in this specification.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * List of: Resources are physical or non-physical components (or some
   * combination of these) within an enterprise's infrastructure or inventory.
   * They are typically consumed or used by services (for example a physical port
   * assigned to a service) or contribute to the realization of a Product (for
   * example, a SIM card). They can be drawn from the Application, Computing and
   * Network domains, and include, for example, Network Elements, software, IT
   * systems, content and information, and technology components.
   * <br/>A ResourceSpecification is an abstract base class for representing a
   * generic means for implementing a particular type of Resource. In essence, a
   * ResourceSpecification defines the common attributes and relationships of a
   * set of related Resources, while Resource defines a specific instance that is
   * based on a particular ResourceSpecification.
   */
  @JsonProperty("resourceSpec")
  private List<@Valid ResourceSpecificationRef> resourceSpecs;

  /**
   * List of: A template of an agreement that can be used when establishing
   * partnerships.
   */
  @JsonProperty("warrantyAgreementSpecification")
  private List<@Valid AgreementSpecification> warrantyAgreementSpecifications;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity warrantyDuration;

  /**
   * List of: A migration, substitution, dependency or exclusivity relationship
   * between/among entity specifications.
   */
  @JsonProperty("warrantySpecRelationship")
  private List<@Valid WarrantySpecificationRelationship> warrantySpecRelationships;

  @JsonProperty("warrantySpecification")
  private List<@Valid WarrantySpecification> warrantySpecifications;
}