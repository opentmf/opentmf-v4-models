package org.opentmf.tmf706.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.general.model.ManagedArtifact;

/**
 * A managed test data schema resource.
 *
 * <p><br/>
 * <strong>Required:</strong> testDataSchemaDefinition<br/>
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
    defaultImpl = TestDataSchema.class
)
@Required(fields = {"testDataSchemaDefinition"})
public class TestDataSchema extends ManagedArtifact implements ITestDataSchema {

  /**
   * Test data schema definition.
   */
  private @Valid TestDataSchemaDefinition testDataSchemaDefinition;
}