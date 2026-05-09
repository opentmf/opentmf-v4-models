package org.opentmf.tmf725.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.CharacteristicSpecification;
import org.opentmf.common.model.EntitySpecificationRelationship;
import org.opentmf.common.model.PromotionUpdateBase;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TargetEntitySchema;
import org.opentmf.general.model.PolicySpecificationRef;

/**
 * MetadataSpecification is a class that describes the specification of a
 * specific metadata asset
 * <br/>Skipped properties: id,href,lastUpdate,{@literal @}baseType,{@literal @}schemaLocation,{@literal @}type.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-725: Metadata Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class MetadataSpecificationUpdate extends PromotionUpdateBase implements IMetadataSpecificationUpdate {

  /**
   * Attachments that may be of relevance to this specification, such as picture,
   * document, media.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * A type of MetadataSpecification that belongs to a grouping of
   * MetadataSpecifications. It inherits of all attributes of
   * MetadataSpecification.
   */
  @JsonProperty("compositeMetadataSpecification")
  private List<@Valid CompositeMetadataSpecification> compositeMetadataSpecifications;

  /**
   * Relationship to another specification.
   */
  @JsonProperty("entitySpecRelationship")
  private List<@Valid EntitySpecificationRelationship> entitySpecRelationships;

  /**
   * Indicates if the metadata specification is part of a composite specification.
   */
  private Boolean isComposed;

  /**
   * List of characteristics that the entity can take.
   */
  @JsonProperty("metadataSpecCharacteristic")
  private List<@Valid CharacteristicSpecification> metadataSpecCharacteristics;

  /**
   * This is a list of policy references applied to this specification.
   */
  @JsonProperty("policySpecificationRef")
  private List<@Valid PolicySpecificationRef> policySpecificationRefs;

  /**
   * Parties who manage or otherwise have an interest in this specification.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * The reference object to the schema and type of target entity which is
   * described by a specification.
   */
  private @Valid TargetEntitySchema targetEntitySchema;
}