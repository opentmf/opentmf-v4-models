package org.opentmf.tmf710.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class GeneralTestArtifactDeleteEventPayload implements IGeneralTestArtifactDeleteEventPayload {

  /**
   * A managed general test artifact resource.
   */
  private @Valid GeneralTestArtifact generalTestArtifact;
}