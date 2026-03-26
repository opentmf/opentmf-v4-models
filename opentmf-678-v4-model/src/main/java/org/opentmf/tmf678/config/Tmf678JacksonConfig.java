package org.opentmf.tmf678.config;

import lombok.Generated;
import org.opentmf.customer.config.TmfCustomerJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf678JacksonConfig {

  @Generated
  private Tmf678JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfCustomerJacksonConfig.registerExtensions(builder);
  }
}
