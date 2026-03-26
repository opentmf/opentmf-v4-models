package org.opentmf.common.config;

import lombok.Generated;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.GeoJsonLineString;
import org.opentmf.common.model.GeoJsonMultiLineString;
import org.opentmf.common.model.GeoJsonMultiPoint;
import org.opentmf.common.model.GeoJsonPoint;
import org.opentmf.common.model.GeoJsonPolygon;
import org.opentmf.common.model.GeographicLocation;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class TmfCommonJacksonConfig {

  @Generated
  private TmfCommonJacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    builder.registerSubtypes(
      AttachmentRefOrValue.class,
      GeoJsonLineString.class,
      GeoJsonMultiLineString.class,
      GeoJsonMultiPoint.class,
      GeoJsonPoint.class,
      GeoJsonPolygon.class,
      GeographicLocation.class);
  }
}
