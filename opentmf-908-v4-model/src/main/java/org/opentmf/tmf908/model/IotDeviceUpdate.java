package org.opentmf.tmf908.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.GeographicLocation;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.Place;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.ResourceRelationship;
import org.opentmf.common.model.Rule;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * #TODO
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> category<br/>
 * </p>
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
    defaultImpl = IotDeviceUpdate.class
)
@Required(fields = {"category"})
public class IotDeviceUpdate extends GSMACommons implements IIotDeviceUpdate {

  /**
   * Structured textual way of describing how to find a Property in an urban area
   * (country properties are often
   * <br/>defined differently).
   * <br/>Note : Address corresponds to SID UrbanPropertyAddress.
   */
  private @Valid Address address;

  private @SafeText String areaServed;

  private BigDecimal batteryLevel;

  @JsonProperty("category")
  private @Size(min = 1) List<@Valid CategoryType> categories;

  @JsonProperty("characteristic")
  private List<@Valid ResourceCharacteristic> characteristics;

  /**
   * #TODO.
   */
  private @Valid Configuration configuration;

  /**
   * List of: This is the endpoint exposed by the IoT Device to authorized users.
   */
  @JsonProperty("dataAccessEndPoint")
  private List<@Valid DataAccessEndpoint> dataAccessEndPoints;

  private OffsetDateTime dateFirstUsed;

  private OffsetDateTime dateInstalled;

  private OffsetDateTime dateLastCalibration;

  private OffsetDateTime dateLastValueReported;

  private OffsetDateTime dateManufactured;

  private @SafeText String deviceState;

  /**
   * NGSI Entity type.
   */
  private @SafeText String deviceType;

  /**
   * A date time( DateTime). The date till the resource is effective.
   */
  private OffsetDateTime endDate;

  private @SafeText String firmwareVersion;

  private @SafeText String hardwareVersion;

  /**
   * The life cycle state of the resource.
   */
  private @SafeText String lifecycleState;

  /**
   * A GeographicLocation is a pure-virtual super-class to the GeoJSON-aligned
   * geometries of Point (addresses and locations), MultiPoint, LineString
   * (streets, highways and boundaries), MultiLineString and Polygon (countries,
   * provinces, tracts of land). Use the {@literal @}type attribute to specify which of these
   * is being specified by the geometry attribute.
   */
  private @Valid GeographicLocation location;

  /**
   * List of: #TODO.
   */
  @JsonProperty("macAddress")
  private List<@Valid MacAddressType> macAddresses;

  /**
   * This is a string attribute that defines the date of manufacture of this item
   * in the fixed format "dd/mm/yyyy". This is an optional attribute.
   */
  private OffsetDateTime manufactureDate;

  private @SafeText String mnc;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  private @SafeText String osVersion;

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
   * This defines the current power status of the hardware item. Values include:
   * <br/>
   * <br/> 0: Unknown
   * <br/> 1: Not Applicable
   * <br/> 2: No Power Applied
   * <br/> 3: Full Power Applied
   * <br/> 4: Power Save - Normal
   * <br/> 5: Power Save - Degraded
   * <br/> 6: Power Save - Standby
   * <br/> 7: Power Save - Critical
   * <br/> 8: Power Save - Low Power Mode
   * <br/> 9: Power Save - Unknown
   * <br/> 10: Power Cycle
   * <br/> 11: Power Warning
   * <br/> 12: Power Off.
   */
  private @SafeText String powerState;

  private @SafeText String provider;

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

  @JsonProperty("rule")
  private List<@Valid Rule> rules;

  /**
   * This is a string that represents a manufacturer-allocated number used to
   * identify different instances of the same hardware item. The ModelNumber and
   * PartNumber attributes are used to identify different types of hardware items.
   * This is a REQUIRED attribute.
   */
  private @SafeText String serialNumber;

  private @SafeText String softwareVersion;

  /**
   * A date time( DateTime). The date from which the resource is effective.
   */
  private OffsetDateTime startDate;

  private @SafeText String value;

  /**
   * A field that identifies the specific version of an instance of a resource.
   */
  private @SafeText String version;

  /**
   * This is a string that identifies the version of this object. This is an
   * optional attribute.
   */
  private @SafeText String versionNumber;
}