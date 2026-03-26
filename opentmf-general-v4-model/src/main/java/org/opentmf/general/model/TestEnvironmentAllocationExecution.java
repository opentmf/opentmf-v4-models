package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * REST resource for test environment allocation lifecycle.
 *
 * <p><br/>
 * <strong>Required:</strong> resourceManagerUrl<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-707: Test Result Management API</li>
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
    defaultImpl = TestEnvironmentAllocationExecution.class
)
@Required(fields = {"resourceManagerUrl"})
public class TestEnvironmentAllocationExecution extends Execution implements ITestEnvironmentAllocationExecution {

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

  private URI resourceManagerUrl;

  /**
   * A reference to a managed test scenario resource.
   */
  private @Valid TestScenarioRef testScenario;
}