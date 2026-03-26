package org.opentmf.tmf713.config;

import lombok.Generated;
import org.opentmf.partner.config.TmfPartnerJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf713JacksonConfig {

  @Generated
  private Tmf713JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfPartnerJacksonConfig.registerExtensions(builder);
  }
}
