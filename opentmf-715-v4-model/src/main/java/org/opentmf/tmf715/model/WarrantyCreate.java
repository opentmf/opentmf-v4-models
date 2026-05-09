package org.opentmf.tmf715.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AgreementRef;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.ProductRefOrValue;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.RelatedPlaceRefOrValue;
import org.opentmf.common.model.ResourceRefOrValue;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.common.model.WarrantyRelationship;
import org.opentmf.common.model.WarrantySpecificationRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.general.model.EntityRelationship;
import org.opentmf.general.model.EntitySpecificationRef;

/**
 * Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
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
    defaultImpl = WarrantyCreate.class
)
@Required(fields = {"name"})
public class WarrantyCreate extends Extensible implements IWarrantyCreate {

  /**
   * List of: A product to be created defined by value or existing defined by
   * reference. The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType
   * are related to the product entity and not the RelatedProductRefOrValue class
   * itself.
   */
  @JsonProperty("appliesToProduct")
  private List<@Valid ProductRefOrValue> appliesToProducts;

  /**
   * List of: Resource is an abstract entity that describes the common set of
   * attributes shared by all concrete resources. The polymorphic attributes
   * {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the Resource entity and
   * not the related ResourceRefOrValue class itself.
   */
  @JsonProperty("appliesToResource")
  private List<@Valid ResourceRefOrValue> appliesToResources;

  /**
   * Attachments that may be of relevance to this entity, such as picture,
   * document, media.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * A string used to give a context to the entity.
   */
  private @SafeText String context;

  /**
   * free-text description of the entity.
   */
  private @SafeText String description;

  /**
   * A date time( DateTime). The date till the entity is effective.
   */
  private @SafeText String endDate;

  /**
   * A list of entities related to this entity.
   */
  @JsonProperty("entityRelationship")
  private List<@Valid EntityRelationship> entityRelationships;

  /**
   * reference to an EntitySpecification object.
   */
  private @Valid EntitySpecificationRef entitySpecification;

  /**
   * isBundle determines whether an entity represents a single entity (false), or
   * a bundle of entities(true).
   */
  private Boolean isBundle;

  /**
   * isExternal determines whether an entity represents an external entity in the
   * inventory.
   */
  private Boolean isExternal;

  /**
   * A string used to give a name to the entity.
   */
  private @SafeText String name;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * List of: Related Entity reference. A related place defines a place described
   * by reference or by value linked to a specific entity. The polymorphic
   * attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place
   * entity and not the RelatedPlaceRefOrValue class itself.
   */
  @JsonProperty("place")
  private List<@Valid RelatedPlaceRefOrValue> places;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A date time( DateTime). The date from which the entity is effective.
   */
  private @SafeText String startDate;

  /**
   * Valid values for the lifecycle state of the service
   * <br/><p>Recommended values: feasibilityChecked, designed, reserved, inactive,
   * active, terminated.
   *
   * @see org.opentmf.tmf715.model.WarrantyStateType
   */
  private @SafeText String state;

  /**
   * The life cycle state of the entity.
   */
  private @SafeText String status;

  /**
   * A date time( DateTime). The date that the entity status changed.
   */
  private @SafeText String statusChangeDate;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * A field that identifies the specific version of an instance of an entity.
   */
  private @SafeText String version;

  @JsonProperty("warranty")
  private List<@Valid Warranty> warranties;

  /**
   * List of: Agreement reference. An agreement represents a contract or
   * arrangement, either written or verbal and sometimes enforceable by law, such
   * as a service level agreement or a customer price agreement. An agreement
   * involves a number of other business entities, such as products, services, and
   * resources and/or their specifications.
   */
  @JsonProperty("warrantyAgreement")
  private List<@Valid AgreementRef> warrantyAgreements;

  /**
   * List of: Linked products to the one instantiate, such as [bundled] if the
   * product is a bundle and you want to describe the bundled products inside this
   * bundle; [reliesOn] if the product needs another already owned product to rely
   * on (e.g. an option on an already owned mobile access product) [targets] or
   * [isTargeted] (depending on the way of expressing the link) for any other kind
   * of links that may be useful.
   */
  @JsonProperty("warrantyRelationship")
  private List<@Valid WarrantyRelationship> warrantyRelationships;

  private @Valid WarrantySpecificationRef warrantySpecification;
}