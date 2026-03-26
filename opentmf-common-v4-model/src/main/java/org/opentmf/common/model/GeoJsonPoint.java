package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Container for a GeoJSON Point: A single position.
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
    defaultImpl = GeoJsonPoint.class
)
@JsonTypeName("GeoJsonPoint")
@Required(fields = {"role", "atType", "href", "id"})
public class GeoJsonPoint extends GeographicLocation implements IGeoJsonPoint {

  /**
   * GeoJSON: A single position.
   */
  private @Valid Point geoJson;
}