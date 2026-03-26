package org.opentmf.tmf915.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.EntityRef;
import org.opentmf.common.model.Feature;
import org.opentmf.common.model.RelatedEntityRefOrValue;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.RelatedPlaceRefOrValue;
import org.opentmf.common.model.RelatedServiceOrderItem;
import org.opentmf.common.model.ResourceRef;
import org.opentmf.common.model.ServiceRefOrValue;
import org.opentmf.common.model.ServiceRelationship;
import org.opentmf.common.model.ServiceSpecificationRef;
import org.opentmf.common.model.WarrantyBase;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * AiModel is a base class for defining the AiModel hierarchy
 * <br/>Skipped properties: id,href,serviceDate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-915: AI Management API</li>
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
    defaultImpl = AiModelUpdate.class
)
public class AiModelUpdate extends WarrantyBase implements IAiModelUpdate {

  /**
   * AiModelSpecification is a class that offers characteristics to describe a
   * type of service.
   * <br/>Functionally, it acts as a template by which Services may be
   * instantiated. By sharing the same specification, these services would
   * therefore share the same set of characteristics.
   */
  private @Valid AiModelSpecification aiModelSpecification;

  /**
   * Is it a customer facing or resource facing service.
   */
  private @SafeText String category;

  /**
   * Date when the service ends.
   */
  private OffsetDateTime endDate;

  /**
   * A list of feature associated with this service.
   */
  @JsonProperty("feature")
  private List<@Valid Feature> features;

  private @Valid ResourceRef gpu;

  /**
   * If TRUE, this Service has already been started.
   */
  private Boolean hasStarted;

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
   * with other service(s) in the inventory.
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
   * Reference to Software in Inventory.
   */
  @JsonProperty("software")
  private List<@Valid SoftwareRef> softwares;

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

  /**
   * Entity reference schema to be used for all entityRef class.
   */
  private @Valid EntityRef trainingData;
}