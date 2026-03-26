package org.opentmf.tmf705.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.general.model.ManagedArtifact;

/**
 * A managed test resource API resource.
 *
 * <p><br/>
 * <strong>Required:</strong> testResourceAPIDefinition<br/>
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
    defaultImpl = TestResourceAPI.class
)
@Required(fields = {"testResourceAPIDefinition"})
public class TestResourceAPI extends ManagedArtifact implements ITestResourceAPI {

  /**
   * Test resource API definition.
   */
  private @Valid TestResourceAPIDefinition testResourceAPIDefinition;
}