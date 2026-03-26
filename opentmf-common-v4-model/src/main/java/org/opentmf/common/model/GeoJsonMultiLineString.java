package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A container for GeoJSON MultiLineString: A collection of distinct
 * LineStrings.
 *
 * <p><br/>
 * <strong>Required:</strong> @type, href, id, role<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-673: Geographic Address Management API</li>
 *   <li>TMF-675: Geographic Location Management API</li>
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
    defaultImpl = GeoJsonMultiLineString.class
)
@JsonTypeName("GeoJsonMultiLineString")
@Required(fields = {"role", "atType", "href", "id"})
public class GeoJsonMultiLineString extends GeographicLocation implements IGeoJsonMultiLineString {

  /**
   * A collection of distinct LineStrings.
   */
  private @Valid MultiLineString geoJson;
}