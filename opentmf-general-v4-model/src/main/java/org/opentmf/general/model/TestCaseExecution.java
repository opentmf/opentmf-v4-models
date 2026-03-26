package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * REST resource for the test case execution lifecycle.
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
    defaultImpl = TestCaseExecution.class
)
@Required(fields = {"testEnvironmentProvisioningExecution"})
public class TestCaseExecution extends TestExecution implements ITestCaseExecution {

  /**
   * A reference to a managed test case artifact.
   */
  private @Valid TestCaseRef testCase;
}