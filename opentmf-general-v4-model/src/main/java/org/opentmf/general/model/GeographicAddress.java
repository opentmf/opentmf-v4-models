package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Structured textual way of describing how to find a Property in an urban area
 * (country properties are often defined differently).
 * <br/>Note : Address corresponds to SID UrbanPropertyAddress.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-673: Geographic Address Management API</li>
 *   <li>TMF-691: Federated ID Management API</li>
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
    defaultImpl = GeographicAddress.class
)
@JsonTypeName("GeographicAddress")
public class GeographicAddress extends NamedEntity implements IGeographicAddress {

  /**
   * City that the address is in.
   */
  private @SafeText String city;

  /**
   * Country that the address is in.
   */
  private @SafeText String country;

  /**
   * A GeographicLocation is a pure-virtual super-class to the GeoJSON-aligned
   * geometries of Point (addresses and locations), MultiPoint, LineString
   * (streets, highways and boundaries), MultiLineString and Polygon (countries,
   * provinces, tracts of land). Use the {@literal @}type attribute to specify which of these
   * is being specified by the geometry attribute.
   */
  private @Valid GeographicLocationRefOrValue geographicLocation;

  /**
   * List of: Representation of a GeographicSubAddress 
   * <br/>It is used for addressing within a property in an urban area (country
   * properties are often defined differently). It may refer to a building, a
   * building cluster, or a floor of a multistory building.
   */
  @JsonProperty("geographicSubAddress")
  private List<@Valid GeographicSubAddress> geographicSubAddresses;

  /**
   * An area of defined or undefined boundaries within a local authority or other
   * legislatively defined area, usually rural or semi rural in nature.
   * [ANZLIC-STREET], or a suburb, a bounded locality within a city, town or shire
   * principally of urban character [ANZLICSTREET].
   */
  private @SafeText String locality;

  /**
   * descriptor for a postal delivery area, used to speed and simplify the
   * delivery of mail (also known as zipcode).
   */
  private @SafeText String postcode;

  /**
   * the State or Province that the address is in.
   */
  private @SafeText String stateOrProvince;

  /**
   * Name of the street or other street type.
   */
  private @SafeText String streetName;

  /**
   * Number identifying a specific property on a public street. It may be combined
   * with streetNrLast for ranged addresses.
   */
  private @SafeText String streetNr;

  /**
   * Last number in a range of street numbers allocated to a property.
   */
  private @SafeText String streetNrLast;

  /**
   * Last street number suffix for a ranged address.
   */
  private @SafeText String streetNrLastSuffix;

  /**
   * the first street number suffix.
   */
  private @SafeText String streetNrSuffix;

  /**
   * A modifier denoting a relative direction.
   */
  private @SafeText String streetSuffix;

  /**
   * alley, avenue, boulevard, brae, crescent, drive, highway, lane, terrace,
   * parade, place, tarn, way, wharf.
   */
  private @SafeText String streetType;
}