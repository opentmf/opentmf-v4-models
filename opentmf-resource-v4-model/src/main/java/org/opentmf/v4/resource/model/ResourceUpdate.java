package org.opentmf.v4.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AttachmentRefOrValue;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.Feature;
import org.opentmf.v4.common.model.Note;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.common.model.RelatedPlaceRefOrValue;
import org.opentmf.v4.common.model.ResourceSpecificationRef;

/**
 * Resource is an abstract entity that describes the common set of attributes
 * shared by all concrete resources (e.g. TPE, EQUIPMENT) in the inventory.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> href, id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
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
    defaultImpl = ResourceUpdate.class
)
@Required(fields = {"href", "id"})
public class ResourceUpdate extends Extensible {

  /**
   * Category of the concrete resource. e.g. Gold, Silver for MSISDN concrete
   * resource.
   */
  private @SafeText String category;

  /**
   * free-text description of the resource.
   */
  private @SafeText String description;

  /**
   * A date time( DateTime). The date till the resource is operating.
   */
  private OffsetDateTime endOperatingDate;

  /**
   * A string used to give a name to the resource.
   */
  private @SafeText String name;

  /**
   * A field that identifies the specific version of an instance of a resource.
   */
  private @SafeText String resourceVersion;

  /**
   * A date time( DateTime). The date from which the resource is operating.
   */
  private OffsetDateTime startOperatingDate;

  /**
   * Configuration features.
   */
  @JsonProperty("activationFeature")
  private List<@Valid Feature> activationFeatures;

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing,
   * operating, retiring and so on.
   *
   * @see org.opentmf.v4.resource.model.ResourceAdministrativeStateType
   */
  private @SafeText String administrativeState;

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing,
   * operating, retiring and so on.
   *
   * @see org.opentmf.v4.resource.model.ResourceOperationalStateType
   */
  private @SafeText String operationalState;

  private @Valid RelatedPlaceRefOrValue place;

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("resourceCharacteristic")
  private List<@Valid Characteristic> resourceCharacteristics;

  /**
   * List of: Linked resources to the one instantiate, such as [bundled] if the
   * resource is a bundle and you want to describe the bundled resources inside
   * this bundle; [reliesOn] if the resource needs another already owned resource
   * to rely on (e.g. an option on an already owned mobile access resource)
   * [targets] or [isTargeted] (depending on the way of expressing the link) for
   * any other kind of links that may be useful.
   */
  @JsonProperty("resourceRelationship")
  private List<@Valid ResourceRelationship> resourceRelationships;

  private @Valid ResourceSpecificationRef resourceSpecification;

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing,
   * operating, retiring and so on.
   *
   * @see org.opentmf.v4.resource.model.ResourceStatusType
   */
  private @SafeText String resourceStatus;

  /**
   * Tracks the lifecycle status of the resource, such as planning, installing,
   * operating, retiring and so on.
   *
   * @see org.opentmf.v4.resource.model.ResourceUsageStateType
   */
  private @SafeText String usageState;
}