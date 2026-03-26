package org.opentmf.tmf708.model;

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
import org.opentmf.general.model.GeneralTestArtifactRef;
import org.opentmf.general.model.TestCaseRef;
import org.opentmf.general.model.TestDataInstanceRef;
import org.opentmf.general.model.TestEnvironmentProvisioningExecution;

/**
 * REST resource for the test case execution lifecycle
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
    defaultImpl = TestCaseExecutionCreate.class
)
@Required(fields = {"testEnvironmentProvisioningExecution"})
public class TestCaseExecutionCreate extends Extensible implements ITestCaseExecutionCreate {

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
   * Possible values for the state of the execution
   * <br/><p>Recommended values: acknowledged, rejected, pending, inProgress,
   * cancelled, completed, failed.
   *
   * @see org.opentmf.general.model.ExecutionStateType
   */
  private @SafeText String state;

  /**
   * A reference to a managed test case artifact.
   */
  private @Valid TestCaseRef testCase;

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