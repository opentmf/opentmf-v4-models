package org.opentmf.tmf699.config;

import lombok.Generated;
import org.opentmf.common.config.TmfCommonJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf699JacksonConfig {

  @Generated
  private Tmf699JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfCommonJacksonConfig.registerExtensions(builder);
  }
}
