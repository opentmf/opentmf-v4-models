package org.opentmf.v4.tmf652.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.resource.config.TmfResourceJacksonConfig;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf652JacksonConfig {

  @Generated
  private Tmf652JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    TmfResourceJacksonConfig.registerExtensions(objectMapper);
  }
}
