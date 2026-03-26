package org.opentmf.tmf705.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.RelatedPartyWithContactInfo;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.general.model.TestAgreement;
import org.opentmf.general.model.UpdateBase;

/**
 * A managed provisioning artifact resource
 * <br/>Skipped properties: id,href,version.
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
    defaultImpl = ProvisioningArtifactUpdate.class
)
@Required(fields = {"provisioningArtifactDefinition"})
public class ProvisioningArtifactUpdate extends UpdateBase implements IProvisioningArtifactUpdate {

  private @Valid TestAgreement agreement;

  /**
   * Provisioning artifact definition.
   */
  private @Valid ProvisioningArtifactDefinition provisioningArtifactDefinition;

  /**
   * List of: Related party specialization that includes contact information.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedPartyWithContactInfo> relatedParties;
}