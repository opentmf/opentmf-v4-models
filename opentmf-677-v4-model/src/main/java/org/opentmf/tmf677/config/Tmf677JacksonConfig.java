package org.opentmf.tmf677.config;

import lombok.Generated;
import org.opentmf.product.config.TmfProductJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf677JacksonConfig {

  @Generated
  private Tmf677JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfProductJacksonConfig.registerExtensions(builder);
  }
}
