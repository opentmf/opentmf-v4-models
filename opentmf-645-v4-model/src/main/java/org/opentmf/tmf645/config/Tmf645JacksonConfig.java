package org.opentmf.tmf645.config;

import lombok.Generated;
import org.opentmf.service.config.TmfServiceJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf645JacksonConfig {

  @Generated
  private Tmf645JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfServiceJacksonConfig.registerExtensions(builder);
  }
}
