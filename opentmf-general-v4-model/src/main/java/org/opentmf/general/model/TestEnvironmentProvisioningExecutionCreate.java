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
 * REST resource for test environment provisioning lifecycle
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> testEnvironmentAllocationExecution<br/>
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
    defaultImpl = TestEnvironmentProvisioningExecutionCreate.class
)
@Required(fields = {"testEnvironmentAllocationExecution"})
public class TestEnvironmentProvisioningExecutionCreate extends Extensible implements ITestEnvironmentProvisioningExecutionCreate {

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
   * List of: A reference to a managed provisioning artifact resource.
   */
  @JsonProperty("provisioningArtifact")
  private List<@Valid ProvisioningArtifactRef> provisioningArtifacts;

  /**
   * Possible values for the state of the execution
   * <br/><p>Recommended values: acknowledged, rejected, pending, inProgress,
   * cancelled, completed, failed.
   *
   * @see org.opentmf.general.model.ExecutionStateType
   */
  private @SafeText String state;

  /**
   * REST resource for test environment allocation lifecycle.
   */
  private @Valid TestEnvironmentAllocationExecution testEnvironmentAllocationExecution;
}