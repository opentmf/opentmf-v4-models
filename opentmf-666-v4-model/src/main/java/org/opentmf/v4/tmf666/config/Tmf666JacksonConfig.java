package org.opentmf.v4.tmf666.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.customer.config.TmfCustomerJacksonConfig;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf666JacksonConfig {

  @Generated
  private Tmf666JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    TmfCustomerJacksonConfig.registerExtensions(objectMapper);
  }
}
