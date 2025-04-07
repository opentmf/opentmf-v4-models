package org.opentmf.v4.tmf651.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.common.config.TmfCommonJacksonConfig;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf651JacksonConfig {

  @Generated
  private Tmf651JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    TmfCommonJacksonConfig.registerExtensions(objectMapper);
  }
}
