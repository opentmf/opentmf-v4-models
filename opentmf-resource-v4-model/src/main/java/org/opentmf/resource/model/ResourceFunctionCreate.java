package org.opentmf.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A ResourceFunction is a behavior to transform inputs of any nature into
 * outputs of any nature independently from the way it is provided.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name, resourceSpecification<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-664: Resource Function Activation Management API</li>
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
    defaultImpl = ResourceFunctionCreate.class
)
@Required(fields = {"name", "resourceSpecification"})
public class ResourceFunctionCreate extends ResourceFunctionUpdate implements IResourceFunctionCreate {

  /**
   * ResourceUsageStateType enumerations
   * <br/><p>Recommended values: idle, active, busy.
   *
   * @see org.opentmf.common.model.ResourceUsageStateType
   */
  private @SafeText String usageState;
}