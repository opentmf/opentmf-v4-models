package org.opentmf.tmf706.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.general.model.ManagedArtifact;

/**
 * A managed test data instance resource.
 *
 * <p><br/>
 * <strong>Required:</strong> testDataInstanceDefinition<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-706: Test Data Management API</li>
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
    defaultImpl = TestDataInstance.class
)
@Required(fields = {"testDataInstanceDefinition"})
public class TestDataInstance extends ManagedArtifact implements ITestDataInstance {

  /**
   * Test data instance definition.
   */
  private @Valid TestDataInstanceDefinition testDataInstanceDefinition;
}