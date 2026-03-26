package org.opentmf.tmf679.config;

import lombok.Generated;
import org.opentmf.product.config.TmfProductJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf679JacksonConfig {

  @Generated
  private Tmf679JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfProductJacksonConfig.registerExtensions(builder);
  }
}
