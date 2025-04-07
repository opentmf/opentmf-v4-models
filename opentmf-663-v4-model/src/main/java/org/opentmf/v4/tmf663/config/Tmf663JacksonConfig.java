package org.opentmf.v4.tmf663.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.product.config.TmfProductJacksonConfig;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf663JacksonConfig {

  @Generated
  private Tmf663JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    TmfProductJacksonConfig.registerExtensions(objectMapper);
  }
}
