package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A GeographicLocation is a pure-virtual super-class to the GeoJSON-aligned
 * geometries of Point (addresses and locations), MultiPoint, LineString
 * (streets, highways and boundaries), MultiLineString and Polygon (countries,
 * provinces, tracts of land). Use the {@literal @}type attribute to specify which of these
 * is being specified by the geometry attribute.
 *
 * <p><br/>
 * <strong>Required:</strong> @type<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-673: Geographic Address Management API</li>
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
    defaultImpl = GeographicLocationRefOrValue.class
)
@Required(fields = {"atType"})
public class GeographicLocationRefOrValue extends EntityRef {

  /**
   * A bounding box array that contains the geometry. The axes order follows the
   * axes order of the geometry.
   */
  private List<BigDecimal> bbox;
}