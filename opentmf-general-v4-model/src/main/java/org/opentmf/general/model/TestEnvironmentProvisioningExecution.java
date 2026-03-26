package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * REST resource for test environment provisioning lifecycle.
 *
 * <p><br/>
 * <strong>Required:</strong> testEnvironmentAllocationExecution<br/>
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
    defaultImpl = TestEnvironmentProvisioningExecution.class
)
@Required(fields = {"testEnvironmentAllocationExecution"})
public class TestEnvironmentProvisioningExecution extends Execution implements ITestEnvironmentProvisioningExecution {

  /**
   * List of: A reference to a managed provisioning artifact resource.
   */
  @JsonProperty("provisioningArtifact")
  private List<@Valid ProvisioningArtifactRef> provisioningArtifacts;

  /**
   * REST resource for test environment allocation lifecycle.
   */
  private @Valid TestEnvironmentAllocationExecution testEnvironmentAllocationExecution;
}