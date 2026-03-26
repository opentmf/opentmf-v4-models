package org.opentmf.tmf674.config;

import lombok.Generated;
import org.opentmf.general.config.TmfGeneralJacksonConfig;
import org.opentmf.tmf674.model.GeographicSite;
import tools.jackson.databind.json.JsonMapper;

/**
 * Performs JsonMapper initializations for this layer.
 *
 * @author Gökhan Demir
 */
public final class Tmf674JacksonConfig {

  @Generated
  private Tmf674JacksonConfig() {
  }

  public static void registerExtensions(JsonMapper.Builder builder) {
    builder.registerSubtypes(
      GeographicSite.class);
    TmfGeneralJacksonConfig.registerExtensions(builder);
  }
}
