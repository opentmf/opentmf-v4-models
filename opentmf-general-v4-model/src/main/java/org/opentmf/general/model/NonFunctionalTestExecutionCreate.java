package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * REST resource for the non-functional test execution lifecycle
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> testEnvironmentProvisioningExecution<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-708: Test Execution Management API</li>
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
    defaultImpl = NonFunctionalTestExecutionCreate.class
)
@Required(fields = {"testEnvironmentProvisioningExecution"})
public class NonFunctionalTestExecutionCreate extends Extensible implements INonFunctionalTestExecutionCreate {

  /**
   * Data correlation ID passed in by the API consumer.
   */
  @SafeId
  @Size(max = 100)
  private String dataCorrelationId;

  /**
   * List of: A reference to a managed general test artifact resource.
   */
  @JsonProperty("generalTestArtifact")
  private List<@Valid GeneralTestArtifactRef> generalTestArtifacts;

  /**
   * A reference to a managed non-functional test model resource.
   */
  private @Valid NonFunctionalTestModelRef nonFunctionalTestModel;

  /**
   * Possible values for the state of the execution
   * <br/><p>Recommended values: acknowledged, rejected, pending, inProgress,
   * cancelled, completed, failed.
   *
   * @see org.opentmf.general.model.ExecutionStateType
   */
  private @SafeText String state;

  /**
   * List of: A reference to a managed test data instance resource.
   */
  @JsonProperty("testDataInstance")
  private List<@Valid TestDataInstanceRef> testDataInstances;

  /**
   * REST resource for test environment provisioning lifecycle.
   */
  private @Valid TestEnvironmentProvisioningExecution testEnvironmentProvisioningExecution;
}