package org.opentmf.customer.config;

import lombok.Generated;
import org.opentmf.common.config.TmfCommonJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class TmfCustomerJacksonConfig {

  @Generated
  private TmfCustomerJacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfCommonJacksonConfig.registerExtensions(builder);
  }
}
