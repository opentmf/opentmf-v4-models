package org.opentmf.partner.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AssociationBase;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.CharacteristicSpecification;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Definition of the nature of a Shipment. For example, could be a standard
 * ground delivery, overnight express with signature required by an adult, etc.
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
    defaultImpl = ShipmentSpecification.class
)
public class ShipmentSpecification extends AssociationBase implements IShipmentSpecification {

  /**
   * Attachments that may be of relevance to this specification, such as picture,
   * document, media.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

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
   * List of characteristics that the shipment can take.
   */
  @JsonProperty("shipmentSpecificationCharacteristic")
  private List<@Valid CharacteristicSpecification> shipmentSpecificationCharacteristics;

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