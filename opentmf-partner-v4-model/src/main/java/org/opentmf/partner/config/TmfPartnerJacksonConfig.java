package org.opentmf.partner.config;

import lombok.Generated;
import org.opentmf.common.config.TmfCommonJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class TmfPartnerJacksonConfig {

  @Generated
  private TmfPartnerJacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfCommonJacksonConfig.registerExtensions(builder);
  }
}
