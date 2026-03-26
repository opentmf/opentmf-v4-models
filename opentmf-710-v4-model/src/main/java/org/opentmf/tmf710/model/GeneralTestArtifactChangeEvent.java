package org.opentmf.tmf710.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-710: General Test Artifact Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class GeneralTestArtifactChangeEvent extends EventBase implements IGeneralTestArtifactChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid GeneralTestArtifactChangeEventPayload event;
}