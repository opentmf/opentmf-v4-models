package org.opentmf.tmf707.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A managed test case result resource.
 *
 * <p><br/>
 * <strong>Required:</strong> testExecution, testSuiteResultDefinition<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-707: Test Result Management API</li>
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
    defaultImpl = TestSuiteResult.class
)
@Required(fields = {"testExecution", "testSuiteResultDefinition"})
public class TestSuiteResult extends Entity implements ITestSuiteResult {

  private @Valid TestSuiteExecutionRefOrValue testExecution;

  /**
   * Test suite result definition.
   */
  private @Valid TestSuiteResultDefinition testSuiteResultDefinition;
}