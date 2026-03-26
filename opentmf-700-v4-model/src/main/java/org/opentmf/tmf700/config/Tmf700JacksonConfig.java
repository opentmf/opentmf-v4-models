package org.opentmf.tmf700.config;

import lombok.Generated;
import org.opentmf.partner.config.TmfPartnerJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf700JacksonConfig {

  @Generated
  private Tmf700JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfPartnerJacksonConfig.registerExtensions(builder);
  }
}
