package org.opentmf.tmf725.config;

import lombok.Generated;
import org.opentmf.general.config.TmfGeneralJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf725JacksonConfig {

  @Generated
  private Tmf725JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfGeneralJacksonConfig.registerExtensions(builder);
  }
}
