package org.opentmf.tmf717.config;

import lombok.Generated;
import org.opentmf.customer.config.TmfCustomerJacksonConfig;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf717JacksonConfig {

  @Generated
  private Tmf717JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    TmfCustomerJacksonConfig.registerExtensions(builder);
  }
}
