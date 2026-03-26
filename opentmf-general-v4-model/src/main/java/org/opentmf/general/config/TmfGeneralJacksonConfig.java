package org.opentmf.general.config;

import lombok.Generated;
import org.opentmf.common.config.TmfCommonJacksonConfig;
import org.opentmf.general.model.GeographicAddress;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class TmfGeneralJacksonConfig {

  @Generated
  private TmfGeneralJacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    builder.registerSubtypes(
      GeographicAddress.class);
    TmfCommonJacksonConfig.registerExtensions(builder);
  }
}
