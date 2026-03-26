package org.opentmf.tmf709.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.general.model.ManagedArtifact;

/**
 * A managed test scenario resource.
 *
 * <p><br/>
 * <strong>Required:</strong> testScenarioDefinition<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-709: Test Scenario Management API</li>
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
    defaultImpl = TestScenario.class
)
@Required(fields = {"testScenarioDefinition"})
public class TestScenario extends ManagedArtifact implements ITestScenario {

  /**
   * Test scenario definition.
   */
  private @Valid TestScenarioDefinition testScenarioDefinition;
}