package org.opentmf.v4.tmf681.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.common.config.TmfCommonJacksonConfig;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf681JacksonConfig {

  @Generated
  private Tmf681JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    TmfCommonJacksonConfig.registerExtensions(objectMapper);
  }
}
