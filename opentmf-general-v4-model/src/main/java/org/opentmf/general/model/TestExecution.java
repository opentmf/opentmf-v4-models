package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * The base for all Test Execution resources.
 *
 * <p><br/>
 * <strong>Required:</strong> testEnvironmentProvisioningExecution<br/>
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
    defaultImpl = TestExecution.class
)
@Required(fields = {"testEnvironmentProvisioningExecution"})
public class TestExecution extends Execution implements ITestExecution {

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