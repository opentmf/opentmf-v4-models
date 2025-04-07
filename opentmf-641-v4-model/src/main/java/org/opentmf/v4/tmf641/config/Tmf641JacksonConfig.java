package org.opentmf.v4.tmf641.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Generated;
import org.opentmf.v4.service.config.TmfServiceJacksonConfig;
import org.opentmf.v4.tmf641.model.ServiceOrderErrorMessage;
import org.opentmf.v4.tmf641.model.ServiceOrderItemErrorMessage;

/**
 * Performs ObjectMapper initializations for this layer.
 *
 * @author Gokhan Demir
 */
public final class Tmf641JacksonConfig {

  @Generated
  private Tmf641JacksonConfig() {
  }

  public static void registerExtensions(ObjectMapper objectMapper) {
    objectMapper.registerSubtypes(
      ServiceOrderErrorMessage.class,
      ServiceOrderItemErrorMessage.class);
    TmfServiceJacksonConfig.registerExtensions(objectMapper);
  }
}
