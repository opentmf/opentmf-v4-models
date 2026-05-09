package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Service is a base class for defining the Service hierarchy. All Services are
 * characterized as either being possibly visible and usable by a Customer or
 * not. This gives rise to the two subclasses of Service: CustomerFacingService
 * and ResourceFacingService.
 * <br/>Skipped properties: id,href,serviceDate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-640: Service Activation Management API</li>
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
    defaultImpl = ServiceUpdate.class
)
public class ServiceUpdate extends Extensible implements IServiceUpdate {

  /**
   * Is it a customer facing or resource facing service.
   */
  private @SafeText String category;

  /**
   * Free-text description of the service.
   */
  private @SafeText String description;

  /**
   * Date when the service ends.
   */
  private OffsetDateTime endDate;

  /**
   * A list of feature associated with this service.
   */
  @JsonProperty("feature")
  private List<@Valid Feature> features;

  /**
   * If TRUE, this Service has already been started.
   */
  private Boolean hasStarted;

  /**
   * If true, the service is a ServiceBundle which regroup a service hierarchy. If
   * false, the service is a 'atomic' service (hierarchy leaf).
   */
  private Boolean isBundle;

  /**
   * If FALSE and hasStarted is FALSE, this particular Service has NOT been
   * enabled for use - if FALSE and hasStarted is TRUE then the service has
   * failed.
   */
  private Boolean isServiceEnabled;

  /**
   * If TRUE, this Service can be changed without affecting any other services.
   */
  private Boolean isStateful;

  /**
   * Name of the service.
   */
  private @SafeText String name;

  /**
   * A list of notes made on this service.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * A list of places (Place [*]). Used to define a place useful for the service
   * (for example a geographical place where the service is installed).
   */
  @JsonProperty("place")
  private List<@Valid RelatedPlaceRefOrValue> places;

  /**
   * A list of related entity in relationship with this service.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntityRefOrValue> relatedEntities;

  /**
   * A list of related party references (RelatedParty [*]). A related party
   * defines party or party role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A list of characteristics that characterize this service
   * (ServiceCharacteristic [*]).
   */
  @JsonProperty("serviceCharacteristic")
  private List<@Valid Characteristic> serviceCharacteristics;

  /**
   * A list of service order items related to this service.
   */
  @JsonProperty("serviceOrderItem")
  private List<@Valid RelatedServiceOrderItem> serviceOrderItems;

  /**
   * A list of service relationships (ServiceRelationship [*]). Describes links
   * with other service(s) in the inventory (useful for describing relies-on,
   * relies-from between CFS for example).
   */
  @JsonProperty("serviceRelationship")
  private List<@Valid ServiceRelationship> serviceRelationships;

  /**
   * Service specification reference: ServiceSpecification(s) required to realize
   * a ProductSpecification.
   */
  private @Valid ServiceSpecificationRef serviceSpecification;

  /**
   * Business type of the service.
   */
  private @SafeText String serviceType;

  /**
   * Date when the service starts.
   */
  private OffsetDateTime startDate;

  /**
   * This attribute is an enumerated integer that indicates how the Service is
   * started, such as: 0: Unknown; 1: Automatically by the managed environment; 2:
   * Automatically by the owning device; 3: Manually by the Provider of the
   * Service; 4: Manually by a Customer of the Provider; 5: Any of the above.
   */
  private @SafeText String startMode;

  /**
   * Valid values for the lifecycle state of the service
   * <br/><p>Recommended values: feasibilityChecked, designed, reserved, inactive,
   * active, terminated.
   *
   * @see org.opentmf.common.model.ServiceStateType
   */
  private @SafeText String state;

  /**
   * A list of supporting resources (SupportingResource [*]).Note: only Service of
   * type RFS can be associated with Resources.
   */
  @JsonProperty("supportingResource")
  private List<@Valid ResourceRef> supportingResources;

  /**
   * A list of supporting services (SupportingService [*]). A collection of
   * services that support this service (bundling, link CFS to RFS).
   */
  @JsonProperty("supportingService")
  private List<@Valid ServiceRefOrValue> supportingServices;
}