package org.opentmf.tmf672.config;

import lombok.Generated;
import org.opentmf.partner.config.TmfPartnerJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf672JacksonConfig {

  @Generated
  private Tmf672JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfPartnerJacksonConfig.registerExtensions(builder);
  }
}
