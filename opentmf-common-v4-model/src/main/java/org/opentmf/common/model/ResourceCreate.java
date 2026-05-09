package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Resource is an abstract entity that describes the common set of attributes
 * shared by all concrete resources (e.g. TPE, EQUIPMENT) in the inventory.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> href, id, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
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
    defaultImpl = ResourceCreate.class
)
@Required(fields = {"name", "href", "id"})
public class ResourceCreate extends Extensible implements IResourceCreate {

  /**
   * Configuration features.
   */
  @JsonProperty("activationFeature")
  private List<@Valid Feature> activationFeatures;

  /**
   * ResourceAdministrativeStateType enumerations
   * <br/><p>Recommended values: locked, unlocked, shutdown.
   *
   * @see org.opentmf.common.model.ResourceAdministrativeStateType
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
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * ResourceOperationalStateType enumerations
   * <br/><p>Recommended values: enable, disable.
   *
   * @see org.opentmf.common.model.ResourceOperationalStateType
   */
  private @SafeText String operationalState;

  /**
   * Related Entity reference. A related place defines a place described by
   * reference or by value linked to a specific entity. The polymorphic attributes
   * {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place entity and
   * not the RelatedPlaceRefOrValue class itself.
   */
  private @Valid RelatedPlaceRefOrValue place;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
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

  /**
   * Resources are physical or non-physical components (or some combination of
   * these) within an enterprise's infrastructure or inventory. They are typically
   * consumed or used by services (for example a physical port assigned to a
   * service) or contribute to the realization of a Product (for example, a SIM
   * card). They can be drawn from the Application, Computing and Network domains,
   * and include, for example, Network Elements, software, IT systems, content and
   * information, and technology components.
   * <br/>A ResourceSpecification is an abstract base class for representing a
   * generic means for implementing a particular type of Resource. In essence, a
   * ResourceSpecification defines the common attributes and relationships of a
   * set of related Resources, while Resource defines a specific instance that is
   * based on a particular ResourceSpecification.
   */
  private @Valid ResourceSpecificationRef resourceSpecification;

  /**
   * ResourceStatusType enumerations
   * <br/><p>Recommended values: standby, alarm, available, reserved, unknown,
   * suspended.
   *
   * @see org.opentmf.common.model.ResourceStatusType
   */
  private @SafeText String resourceStatus;

  /**
   * A field that identifies the specific version of an instance of a resource.
   */
  private @SafeText String resourceVersion;

  /**
   * A date time( DateTime). The date from which the resource is operating.
   */
  private OffsetDateTime startOperatingDate;

  /**
   * ResourceUsageStateType enumerations
   * <br/><p>Recommended values: idle, active, busy.
   *
   * @see org.opentmf.common.model.ResourceUsageStateType
   */
  private @SafeText String usageState;
}