package org.opentmf.tmf653.config;

import lombok.Generated;
import org.opentmf.service.config.TmfServiceJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf653JacksonConfig {

  @Generated
  private Tmf653JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfServiceJacksonConfig.registerExtensions(builder);
  }
}
