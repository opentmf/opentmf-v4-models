package org.opentmf.tmf640.config;

import lombok.Generated;
import org.opentmf.service.config.TmfServiceJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf640JacksonConfig {

  @Generated
  private Tmf640JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfServiceJacksonConfig.registerExtensions(builder);
  }
}
