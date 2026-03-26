package org.opentmf.tmf657.config;

import lombok.Generated;
import org.opentmf.service.config.TmfServiceJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf657JacksonConfig {

  @Generated
  private Tmf657JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfServiceJacksonConfig.registerExtensions(builder);
  }
}
