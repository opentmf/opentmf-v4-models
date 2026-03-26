package org.opentmf.tmf704.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A managed non-functional test model resource
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> description, nonFunctionalTestModelDefinition, version<br/>
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
    defaultImpl = NonFunctionalTestModelCreate.class
)
@Required(fields = {"nonFunctionalTestModelDefinition", "description", "version"})
public class NonFunctionalTestModelCreate extends NonFunctionalTestModelUpdate implements INonFunctionalTestModelCreate {

  /**
   * The artifact version.
   */
  private @SafeText String version;
}