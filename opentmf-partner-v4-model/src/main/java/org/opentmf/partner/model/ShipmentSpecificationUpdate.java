package org.opentmf.partner.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.CharacteristicSpecification;
import org.opentmf.common.model.ConstraintRef;
import org.opentmf.common.model.EntityCatalogUpdateBase;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TargetShipmentSchema;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Definition of the nature of a Shipment. For example, could be a standard
 * ground delivery, overnight express with signature required by an adult, etc.
 * <br/>Skipped properties: id,href,lastUpdate.
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
    defaultImpl = ShipmentSpecificationUpdate.class
)
public class ShipmentSpecificationUpdate extends EntityCatalogUpdateBase implements IShipmentSpecificationUpdate {

  /**
   * Attachments that may be of relevance to this specification, such as picture,
   * document, media.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * This is a list of constraint references applied to this specification.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  /**
   * isBundle determines whether an ShipmentSpecification represents a single
   * ShipmentSpecification (false), or a bundle of ShipmentSpecification (true).
   */
  private Boolean isBundle;

  /**
   * Parties who manage or otherwise have an interest in this shipment
   * specification.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Relationship to another shipment specification, might be dependency,
   * substitution, etc.
   */
  @JsonProperty("shipmentSpecRelationship")
  private List<@Valid ShipmentSpecificationRelationship> shipmentSpecRelationships;

  /**
   * Possible values for the signature requirement upon receiving the shipment
   * <br/><p>Recommended values: adult, receiver.
   *
   * @see org.opentmf.partner.model.SignatureRequiredByType
   */
  private @SafeText String signatureRequiredBy;

  /**
   * List of characteristics that the shipment can take.
   */
  @JsonProperty("specCharacteristic")
  private List<@Valid CharacteristicSpecification> specCharacteristics;

  /**
   * The reference object to the schema and type of target shipment which is
   * described by shipment specification.
   */
  private @Valid TargetShipmentSchema targetShipmentSchema;
}