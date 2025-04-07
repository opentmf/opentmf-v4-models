package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Container for GeoJSON MultiPoint: A collection of Points.
 *
 * <p><br/>
 * <strong>Required:</strong> @type, geoJson<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-673: Geographic Address Management API</li>
 *   <li>TMF-675: Geographic Location API</li>
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
    defaultImpl = GeoJsonMultiPoint.class
)
@JsonTypeName("GeoJsonMultiPoint")
@Required(fields = {"geoJson", "atType"})
public class GeoJsonMultiPoint extends GeographicLocation {

  private @Valid MultiPoint geoJson;
}