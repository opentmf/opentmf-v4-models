package org.opentmf.tmf707.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A managed test case result resource
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> testCaseResultDefinition, testExecution<br/>
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
    defaultImpl = TestCaseResultUpdate.class
)
@Required(fields = {"testExecution", "testCaseResultDefinition"})
public class TestCaseResultUpdate extends Extensible implements ITestCaseResultUpdate {

  /**
   * Test case result definition.
   */
  private @Valid TestCaseResultDefinition testCaseResultDefinition;

  private @Valid TestCaseExecutionRefOrValue testExecution;
}