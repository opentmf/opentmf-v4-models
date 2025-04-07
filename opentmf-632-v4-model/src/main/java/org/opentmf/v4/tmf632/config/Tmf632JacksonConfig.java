package org.opentmf.v4.tmf632.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.customer.config.TmfCustomerJacksonConfig;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf632JacksonConfig {

  @Generated
  private Tmf632JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    TmfCustomerJacksonConfig.registerExtensions(objectMapper);
  }
}
