package org.opentmf.tmf635.config;

import lombok.Generated;
import org.opentmf.product.config.TmfProductJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf635JacksonConfig {

  @Generated
  private Tmf635JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfProductJacksonConfig.registerExtensions(builder);
  }
}
