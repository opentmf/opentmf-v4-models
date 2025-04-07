package org.opentmf.v4.tmf669.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.customer.config.TmfCustomerJacksonConfig;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf669JacksonConfig {

  @Generated
  private Tmf669JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    TmfCustomerJacksonConfig.registerExtensions(objectMapper);
  }
}
