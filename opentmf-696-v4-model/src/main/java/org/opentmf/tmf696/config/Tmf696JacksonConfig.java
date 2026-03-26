package org.opentmf.tmf696.config;

import lombok.Generated;
import org.opentmf.customer.config.TmfCustomerJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf696JacksonConfig {

  @Generated
  private Tmf696JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfCustomerJacksonConfig.registerExtensions(builder);
  }
}
