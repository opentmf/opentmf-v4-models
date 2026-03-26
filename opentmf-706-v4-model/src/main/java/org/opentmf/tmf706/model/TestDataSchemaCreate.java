package org.opentmf.tmf706.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A managed test data schema resource
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> description, testDataSchemaDefinition, version<br/>
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
    defaultImpl = TestDataSchemaCreate.class
)
@Required(fields = {"testDataSchemaDefinition", "description", "version"})
public class TestDataSchemaCreate extends TestDataSchemaUpdate implements ITestDataSchemaCreate {

  /**
   * The artifact version.
   */
  private @SafeText String version;
}