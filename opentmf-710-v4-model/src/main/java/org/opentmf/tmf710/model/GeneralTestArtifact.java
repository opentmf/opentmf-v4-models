package org.opentmf.tmf710.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.general.model.ManagedArtifact;

/**
 * A managed general test artifact resource.
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = GeneralTestArtifact.class
)
public class GeneralTestArtifact extends ManagedArtifact implements IGeneralTestArtifact {

  /**
   * General test artifact definition.
   */
  private @Valid GeneralTestArtifactDefinition generalArtifactDefinition;
}