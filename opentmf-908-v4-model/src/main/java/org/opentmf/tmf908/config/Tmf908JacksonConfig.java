package org.opentmf.tmf908.config;

import lombok.Generated;
import org.opentmf.resource.config.TmfResourceJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf908JacksonConfig {

  @Generated
  private Tmf908JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfResourceJacksonConfig.registerExtensions(builder);
  }
}
