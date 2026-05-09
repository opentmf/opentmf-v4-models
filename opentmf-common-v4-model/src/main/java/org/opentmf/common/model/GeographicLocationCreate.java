package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A GeographicLocation is a pure-virtual super-class to the GeoJSON-aligned
 * geometries of Point (addresses and locations), MultiPoint, LineString
 * (streets, highways and boundaries), MultiLineString and Polygon (countries,
 * provinces, tracts of land). Use the {@literal @}type attribute to specify which of these
 * is being specified by the geometry attribute.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> @type<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-675: Geographic Location Management API</li>
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
    defaultImpl = GeographicLocationCreate.class
)
@Required(fields = {"atType"})
public class GeographicLocationCreate extends Extensible implements IGeographicLocationCreate {

  /**
   * A user-friendly name for the place, such as [Paris Store], [London Store],
   * [Main Home].
   */
  private @SafeText String name;
}