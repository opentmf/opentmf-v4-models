package org.opentmf.v4.tmf639.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.resource.config.TmfResourceJacksonConfig;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf639JacksonConfig {

  @Generated
  private Tmf639JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    TmfResourceJacksonConfig.registerExtensions(objectMapper);
  }
}
