package org.opentmf.v4.tmf634.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.resource.config.TmfResourceJacksonConfig;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf634JacksonConfig {

  @Generated
  private Tmf634JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    TmfResourceJacksonConfig.registerExtensions(objectMapper);
  }
}
