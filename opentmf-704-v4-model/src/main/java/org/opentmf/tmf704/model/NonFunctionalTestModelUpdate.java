package org.opentmf.tmf704.model;

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
 * A managed non-functional test model resource
 * <br/>Skipped properties: id,href,version.
 *
 * <p><br/>
 * <strong>Required:</strong> nonFunctionalTestModelDefinition<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-704: Test Case Management API</li>
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
    defaultImpl = NonFunctionalTestModelUpdate.class
)
@Required(fields = {"nonFunctionalTestModelDefinition"})
public class NonFunctionalTestModelUpdate extends UpdateBase implements INonFunctionalTestModelUpdate {

  private @Valid TestAgreement agreement;

  /**
   * Non-functional test model definition.
   */
  private @Valid NonFunctionalTestModelDefinition nonFunctionalTestModelDefinition;

  /**
   * List of: Related party specialization that includes contact information.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedPartyWithContactInfo> relatedParties;
}