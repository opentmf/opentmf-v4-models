package org.opentmf.tmf662.config;

import lombok.Generated;
import org.opentmf.general.config.TmfGeneralJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf662JacksonConfig {

  @Generated
  private Tmf662JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfGeneralJacksonConfig.registerExtensions(builder);
  }
}
