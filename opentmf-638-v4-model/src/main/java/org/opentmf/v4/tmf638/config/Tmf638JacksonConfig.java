package org.opentmf.v4.tmf638.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.service.config.TmfServiceJacksonConfig;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf638JacksonConfig {

  @Generated
  private Tmf638JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    TmfServiceJacksonConfig.registerExtensions(objectMapper);
  }
}
