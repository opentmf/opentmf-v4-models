package org.opentmf.tmf710.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A managed general test artifact resource
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> description, version<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-710: General Test Artifact Management API</li>
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
    defaultImpl = GeneralTestArtifactCreate.class
)
@Required(fields = {"description", "version"})
public class GeneralTestArtifactCreate extends GeneralTestArtifactUpdate implements IGeneralTestArtifactCreate {

  /**
   * The artifact version.
   */
  private @SafeText String version;
}