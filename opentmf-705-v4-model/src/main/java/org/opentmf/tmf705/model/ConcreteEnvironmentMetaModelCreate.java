package org.opentmf.tmf705.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A managed concrete environment resource metamodel resource
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> concreteEnvironmentMetaModelDefinition, description, version<br/>
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
    defaultImpl = ConcreteEnvironmentMetaModelCreate.class
)
@Required(fields = {"description", "concreteEnvironmentMetaModelDefinition", "version"})
public class ConcreteEnvironmentMetaModelCreate extends ConcreteEnvironmentMetaModelUpdate implements IConcreteEnvironmentMetaModelCreate {

  /**
   * The artifact version.
   */
  private @SafeText String version;
}