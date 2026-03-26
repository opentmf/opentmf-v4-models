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
 * A managed concrete environment resource metamodel resource
 * <br/>Skipped properties: id,href,version.
 *
 * <p><br/>
 * <strong>Required:</strong> concreteEnvironmentMetaModelDefinition<br/>
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
    defaultImpl = ConcreteEnvironmentMetaModelUpdate.class
)
@Required(fields = {"concreteEnvironmentMetaModelDefinition"})
public class ConcreteEnvironmentMetaModelUpdate extends UpdateBase implements IConcreteEnvironmentMetaModelUpdate {

  private @Valid TestAgreement agreement;

  /**
   * Test environment metamodel definition.
   */
  private @Valid ConcreteEnvironmentMetaModelDefinition concreteEnvironmentMetaModelDefinition;

  /**
   * List of: Related party specialization that includes contact information.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedPartyWithContactInfo> relatedParties;
}