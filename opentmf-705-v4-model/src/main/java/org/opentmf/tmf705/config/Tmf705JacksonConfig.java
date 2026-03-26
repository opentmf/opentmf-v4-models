package org.opentmf.tmf705.config;

import lombok.Generated;
import org.opentmf.general.config.TmfGeneralJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf705JacksonConfig {

  @Generated
  private Tmf705JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfGeneralJacksonConfig.registerExtensions(builder);
  }
}
