package org.opentmf.tmf675.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.GeographicLocation;

/**
 * The event data structure.
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
public class GeographicLocationAttributeValueChangeEventPayload implements IGeographicLocationAttributeValueChangeEventPayload {

  /**
   * A GeographicLocation is a pure-virtual super-class to the GeoJSON-aligned
   * geometries of Point (addresses and locations), MultiPoint, LineString
   * (streets, highways and boundaries), MultiLineString and Polygon (countries,
   * provinces, tracts of land). Use the {@literal @}type attribute to specify which of these
   * is being specified by the geometry attribute.
   */
  private @Valid GeographicLocation geographicLocation;
}