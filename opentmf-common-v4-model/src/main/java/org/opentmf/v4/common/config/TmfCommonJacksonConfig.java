package org.opentmf.v4.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.common.model.AttachmentRefOrValue;
import org.opentmf.v4.common.model.GeoJsonLineString;
import org.opentmf.v4.common.model.GeoJsonMultiLineString;
import org.opentmf.v4.common.model.GeoJsonMultiPoint;
import org.opentmf.v4.common.model.GeoJsonPoint;
import org.opentmf.v4.common.model.GeoJsonPolygon;
import org.opentmf.v4.common.model.GeographicAddress;
import org.opentmf.v4.common.model.GeographicLocation;
import org.opentmf.v4.common.model.GeographicSite;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class TmfCommonJacksonConfig {

  @Generated
  private TmfCommonJacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    objectMapper.registerSubtypes(
      AttachmentRefOrValue.class,
      GeoJsonLineString.class,
      GeoJsonMultiLineString.class,
      GeoJsonMultiPoint.class,
      GeoJsonPoint.class,
      GeoJsonPolygon.class,
      GeographicAddress.class,
      GeographicLocation.class,
      GeographicSite.class);
  }
}
