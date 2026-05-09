package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ConcreteResource;
import org.opentmf.common.model.Entity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Individual mapping from an abstract resource to a list of concrete resources.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-707: Test Result Management API</li>
 *   <li>TMF-708: Test Execution Management API</li>
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
    defaultImpl = ConcreteResourceMapping.class
)
public class ConcreteResourceMapping extends Entity implements IConcreteResourceMapping {

  private @SafeText String abstractResource;

  @JsonProperty("concreteResource")
  private List<@Valid ConcreteResource> concreteResources;
}