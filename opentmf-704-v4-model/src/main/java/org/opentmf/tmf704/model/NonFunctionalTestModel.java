package org.opentmf.tmf704.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.general.model.ManagedArtifact;

/**
 * A managed non-functional test model resource.
 *
 * <p><br/>
 * <strong>Required:</strong> nonFunctionalTestModelDefinition<br/>
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
    defaultImpl = NonFunctionalTestModel.class
)
@Required(fields = {"nonFunctionalTestModelDefinition"})
public class NonFunctionalTestModel extends ManagedArtifact implements INonFunctionalTestModel {

  /**
   * Non-functional test model definition.
   */
  private @Valid NonFunctionalTestModelDefinition nonFunctionalTestModelDefinition;
}