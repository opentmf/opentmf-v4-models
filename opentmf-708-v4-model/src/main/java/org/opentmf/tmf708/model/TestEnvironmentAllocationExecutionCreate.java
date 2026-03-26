package org.opentmf.tmf708.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.general.model.AbstractEnvironmentRef;
import org.opentmf.general.model.ConcreteResourceMapping;
import org.opentmf.general.model.GeneralTestArtifactRef;
import org.opentmf.general.model.TestScenarioRef;

/**
 * REST resource for test environment allocation lifecycle
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> resourceManagerUrl<br/>
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
    defaultImpl = TestEnvironmentAllocationExecutionCreate.class
)
@Required(fields = {"resourceManagerUrl"})
public class TestEnvironmentAllocationExecutionCreate extends Extensible implements ITestEnvironmentAllocationExecutionCreate {

  /**
   * A reference to a managed test abstract environment resource.
   */
  private @Valid AbstractEnvironmentRef abstractEnvironment;

  /**
   * List of: Individual mapping from an abstract resource to a list of concrete
   * resources.
   */
  @JsonProperty("concreteResourceMapping")
  private List<@Valid ConcreteResourceMapping> concreteResourceMappings;

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

  private URI resourceManagerUrl;

  /**
   * Possible values for the state of the execution
   * <br/><p>Recommended values: acknowledged, rejected, pending, inProgress,
   * cancelled, completed, failed.
   *
   * @see org.opentmf.general.model.ExecutionStateType
   */
  private @SafeText String state;

  /**
   * A reference to a managed test scenario resource.
   */
  private @Valid TestScenarioRef testScenario;
}