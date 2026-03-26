package org.opentmf.tmf704.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.general.model.ManagedArtifact;

/**
 * A managed test case resource.
 *
 * <p><br/>
 * <strong>Required:</strong> testCaseDefinition<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-704: Test Case Management API</li>
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
    defaultImpl = TestCase.class
)
@Required(fields = {"testCaseDefinition"})
public class TestCase extends ManagedArtifact implements ITestCase {

  /**
   * Test case definition.
   */
  private @Valid TestCaseDefinition testCaseDefinition;
}