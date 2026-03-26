package org.opentmf.tmf705.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A managed abstract environment resource
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> abstractEnvironmentDefinition, description, version<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-705: Test Environment Management API</li>
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
    defaultImpl = AbstractEnvironmentCreate.class
)
@Required(fields = {"description", "abstractEnvironmentDefinition", "version"})
public class AbstractEnvironmentCreate extends AbstractEnvironmentUpdate implements IAbstractEnvironmentCreate {

  /**
   * The artifact version.
   */
  private @SafeText String version;
}