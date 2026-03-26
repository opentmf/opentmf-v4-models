package org.opentmf.tmf707.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A managed non-functional test result resource.
 *
 * <p><br/>
 * <strong>Required:</strong> nonFunctionalTestResultDefinition, testExecution<br/>
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
    defaultImpl = NonFunctionalTestResult.class
)
@Required(fields = {"nonFunctionalTestResultDefinition", "testExecution"})
public class NonFunctionalTestResult extends Entity implements INonFunctionalTestResult {

  /**
   * Non-functional test result definition.
   */
  private @Valid NonFunctionalTestResultDefinition nonFunctionalTestResultDefinition;

  private @Valid NonFunctionalTestExecutionRefOrValue testExecution;
}