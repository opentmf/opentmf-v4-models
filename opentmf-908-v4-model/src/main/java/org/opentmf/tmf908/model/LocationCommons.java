package org.opentmf.tmf908.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.GeographicLocation;
import org.opentmf.commons.validation.constraints.SafeText;

/**
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
    defaultImpl = LocationCommons.class
)
public class LocationCommons extends Extensible implements ILocationCommons {

  /**
   * Structured textual way of describing how to find a Property in an urban area
   * (country properties are often
   * <br/>defined differently).
   * <br/>Note : Address corresponds to SID UrbanPropertyAddress.
   */
  private @Valid Address address;

  private @SafeText String areaServed;

  /**
   * A GeographicLocation is a pure-virtual super-class to the GeoJSON-aligned
   * geometries of Point (addresses and locations), MultiPoint, LineString
   * (streets, highways and boundaries), MultiLineString and Polygon (countries,
   * provinces, tracts of land). Use the {@literal @}type attribute to specify which of these
   * is being specified by the geometry attribute.
   */
  private @Valid GeographicLocation location;
}