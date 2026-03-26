package org.opentmf.tmf705.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.general.model.ManagedArtifact;

/**
 * A managed provisioning artifact resource.
 *
 * <p><br/>
 * <strong>Required:</strong> provisioningArtifactDefinition<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-705: Test Environment Management API</li>
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
    defaultImpl = ProvisioningArtifact.class
)
@Required(fields = {"provisioningArtifactDefinition"})
public class ProvisioningArtifact extends ManagedArtifact implements IProvisioningArtifact {

  /**
   * Provisioning artifact definition.
   */
  private @Valid ProvisioningArtifactDefinition provisioningArtifactDefinition;
}