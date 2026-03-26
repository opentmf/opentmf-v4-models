package org.opentmf.tmf908.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.Place;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.ResourceRelationship;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This is the endpoint exposed by the IoT Device to authorized users.
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
    defaultImpl = DataAccessEndpoint.class
)
public class DataAccessEndpoint extends NamedEntity implements IDataAccessEndpoint {

  private @SafeText String apiType;

  /**
   * Category of the concrete resource, such as: Gold, Silver for MSISDN concrete
   * resource.
   */
  private @SafeText String category;

  @JsonProperty("characteristic")
  private List<@Valid ResourceCharacteristic> characteristics;

  /**
   * Free-text description of the resource.
   */
  private @SafeText String description;

  /**
   * The date till the resource is effective.
   */
  private OffsetDateTime endDate;

  /**
   * The life cycle state of the resource.
   */
  private @SafeText String lifecycleState;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * List of: Party role reference. A party role represents the part played by a
   * party in a given context.
   */
  @JsonProperty("partyRole")
  private List<@Valid PartyRoleRef> partyRoles;

  /**
   * Place reference. Place defines the places where the products are sold or
   * delivered.
   */
  private @Valid Place place;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

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
   * A date time( DateTime). The date from which the resource is effective.
   */
  private OffsetDateTime startDate;

  /**
   * URI for using the data access API.
   */
  private @SafeText String uri;

  /**
   * The value of the logical resource, such as: 0044746712345 for an MSISDN.
   */
  private @SafeText String value;

  /**
   * A field that identifies the specific version of an instance of a resource.
   */
  private @SafeText String version;
}