package org.opentmf.v4.tmf629.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.customer.config.TmfCustomerJacksonConfig;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf629JacksonConfig {

  @Generated
  private Tmf629JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    TmfCustomerJacksonConfig.registerExtensions(objectMapper);
  }
}
