package org.opentmf.v4.resource.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.common.config.TmfCommonJacksonConfig;
import org.opentmf.v4.resource.model.LogicalResource;
import org.opentmf.v4.resource.model.PhysicalResource;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class TmfResourceJacksonConfig {

  @Generated
  private TmfResourceJacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    objectMapper.registerSubtypes(
      LogicalResource.class,
      PhysicalResource.class);
    TmfCommonJacksonConfig.registerExtensions(objectMapper);
  }
}
