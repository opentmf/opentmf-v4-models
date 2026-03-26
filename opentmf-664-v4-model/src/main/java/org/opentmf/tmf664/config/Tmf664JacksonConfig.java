package org.opentmf.tmf664.config;

import lombok.Generated;
import org.opentmf.resource.config.TmfResourceJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf664JacksonConfig {

  @Generated
  private Tmf664JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfResourceJacksonConfig.registerExtensions(builder);
  }
}
