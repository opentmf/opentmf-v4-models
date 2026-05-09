package org.opentmf.tmf908.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRef;
import org.opentmf.common.model.EntityCatalogUpdateBase;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.ResourceSpecificationRef;
import org.opentmf.common.model.TargetServiceSchema;

/**
 * #TODO
 * <br/>Skipped properties: id,href,lastUpdate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
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
    defaultImpl = IotDeviceSpecificationUpdate.class
)
public class IotDeviceSpecificationUpdate extends EntityCatalogUpdateBase implements IIotDeviceSpecificationUpdate {

  /**
   * A list of attachments (Attachment [*]). Complements the description of the
   * specification through video, pictures...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRef> attachments;

  /**
   * isBundle determines whether a ServiceSpecification represents a single
   * ServiceSpecification (false), or a bundle of ServiceSpecification (true).
   */
  private Boolean isBundle;

  /**
   * A list of related party references (RelatedParty [*]). A related party
   * defines party or party role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A list of service spec characteristics (ServiceSpecCharacteristic [*]). This
   * class represents the key features of this service specification.
   */
  @JsonProperty("resourceSpecCharacteristic")
  private List<@Valid ResourceSpecCharacteristic> resourceSpecCharacteristics;

  /**
   * A list of resource specifications related to this specification, e.g.
   * migration, substitution, dependency or exclusivity relationship.
   */
  @JsonProperty("resourceSpecRelationship")
  private List<@Valid ResourceSpecRelationship> resourceSpecRelationships;

  /**
   * A list of resource specification references (ResourceSpecificationRef [*]).
   * The ResourceSpecification is required for a service specification with type
   * ResourceFacingServiceSpecification (RFSS).
   */
  @JsonProperty("resourceSpecification")
  private List<@Valid ResourceSpecificationRef> resourceSpecifications;

  /**
   * The reference object to the schema and type of target service which is
   * described by service specification.
   */
  private @Valid TargetServiceSchema targetServiceSchema;
}