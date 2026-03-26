package org.opentmf.tmf710.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.RelatedPartyWithContactInfo;
import org.opentmf.general.model.TestAgreement;
import org.opentmf.general.model.UpdateBase;

/**
 * A managed general test artifact resource
 * <br/>Skipped properties: id,href,version.
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
    defaultImpl = GeneralTestArtifactUpdate.class
)
public class GeneralTestArtifactUpdate extends UpdateBase implements IGeneralTestArtifactUpdate {

  private @Valid TestAgreement agreement;

  /**
   * General test artifact definition.
   */
  private @Valid GeneralTestArtifactDefinition generalArtifactDefinition;

  /**
   * List of: Related party specialization that includes contact information.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedPartyWithContactInfo> relatedParties;
}