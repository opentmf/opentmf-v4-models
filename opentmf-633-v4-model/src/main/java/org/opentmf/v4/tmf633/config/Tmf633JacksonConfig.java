package org.opentmf.v4.tmf633.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.service.config.TmfServiceJacksonConfig;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf633JacksonConfig {

  @Generated
  private Tmf633JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    TmfServiceJacksonConfig.registerExtensions(objectMapper);
  }
}
