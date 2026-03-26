package org.opentmf.tmf706.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Attachment;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Test data schema definition.
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
    defaultImpl = TestDataSchemaDefinition.class
)
public class TestDataSchemaDefinition extends Attachment implements ITestDataSchemaDefinition {

  /**
   * The test data schema code.
   */
  private @SafeText String code;
}