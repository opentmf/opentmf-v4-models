package org.opentmf.tmf715.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.general.model.EntityRelationship;
import org.opentmf.general.model.EntitySpecificationRef;

/**
 * MEntity represents an entity that describes the common set of attributes
 * shared by all concrete entities (e.g. Resource, Service, ..) in the Entity
 * Inventory.
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
    defaultImpl = MEntity.class
)
@Required(fields = {"name"})
public class MEntity extends NamedEntity implements IMEntity {

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
  private OffsetDateTime endDate;

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
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A date time( DateTime). The date from which the entity is effective.
   */
  private OffsetDateTime startDate;

  /**
   * The life cycle state of the entity.
   */
  private @SafeText String status;

  /**
   * A date time( DateTime). The date that the entity status changed.
   */
  private OffsetDateTime statusChangeDate;

  /**
   * A field that identifies the specific version of an instance of an entity.
   */
  private @SafeText String version;
}