package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 11 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>AbstractEnvironmentUpdate (705)</li>
 *   <li>ConcreteEnvironmentMetaModelUpdate (705)</li>
 *   <li>GeneralTestArtifactUpdate (710)</li>
 *   <li>NonFunctionalTestModelUpdate (704)</li>
 *   <li>ProvisioningArtifactUpdate (705)</li>
 *   <li>TestCaseUpdate (704)</li>
 *   <li>TestDataInstanceUpdate (706)</li>
 *   <li>TestDataSchemaUpdate (706)</li>
 *   <li>TestResourceAPIUpdate (705)</li>
 *   <li>TestScenarioUpdate (709)</li>
 *   <li>TestSuiteUpdate (704)</li>
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
    defaultImpl = UpdateBase.class
)
public abstract class UpdateBase extends Extensible implements IUpdateBase {

  @JsonProperty("attribute")
  private List<@Valid Attribute> attributes;

  /**
   * The description for the artifact.
   */
  private @SafeText String description;

  /**
   * Possible values for the state of a managed artifact: 'incomplete', 'beta',
   * 'stable', 'deprecated'
   * <br/><p>Recommended values: incomplete, beta, stable, deprecated.
   *
   * @see org.opentmf.general.model.ManagedArtifactStateType
   */
  private @SafeText String state;

  /**
   * The artifact version description.
   */
  private @SafeText String versionDescription;
}