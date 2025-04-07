package org.opentmf.v4.tmf633.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AttachmentRefOrValue;
import org.opentmf.v4.common.model.ConstraintRef;
import org.opentmf.v4.common.model.EntitySpecificationRelationship;
import org.opentmf.v4.common.model.NamedEntity;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * EntitySpecification is a class that offers characteristics to describe a type
 * of entity. Entities are generic constructs that may be used to describe
 * bespoke business entities that are not effectively covered by the existing
 * SID model.
 * <br/>Functionally, the entity specification acts as a template by which
 * entities may be instantiated and described. By sharing the same
 * specification, these entities would therefore share the same set of
 * characteristics.
 * <br/>Note: The ‘configurable’ attribute on the specCharacteristics determines
 * if an entity instantiated from the entity specification can override the
 * value of the attribute. When set to false, the entity instance may not define
 * a value that differs from the value in the specification.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = EntitySpecification.class
)
public class EntitySpecification extends NamedEntity {

  /**
   * Description of the specification.
   */
  private @SafeText String description;

  /**
   * isBundle determines whether specification represents a single specification
   * (false), or a bundle of specifications (true).
   */
  private Boolean isBundle;

  /**
   * Date and time of the last update of the specification.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Used to indicate the current lifecycle status of this catalog item.
   */
  private @SafeText String lifecycleStatus;

  /**
   * specification version.
   */
  private @SafeText String version;

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
   * Relationship to another specification.
   */
  @JsonProperty("entitySpecRelationship")
  private List<@Valid EntitySpecificationRelationship> entitySpecRelationships;

  /**
   * Parties who manage or otherwise have an interest in this specification.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * List of characteristics that the entity can take.
   */
  @JsonProperty("specCharacteristic")
  private List<@Valid CharacteristicSpecification> specCharacteristics;

  /**
   * Pointer to a schema that defines the target entity.
   */
  private @Valid TargetEntitySchema targetEntitySchema;

  /**
   * The period for which this REST resource is valid.
   */
  private @Valid TimePeriod validFor;
}