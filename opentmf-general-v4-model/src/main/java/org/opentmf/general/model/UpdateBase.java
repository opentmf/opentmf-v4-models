package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 11 model classes.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-704: Test Case Management API</li>
 *   <li>TMF-705: Test Environment Management API</li>
 *   <li>TMF-706: Test Data Management API</li>
 *   <li>TMF-709: Test Scenario Management API</li>
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
    defaultImpl = UpdateBase.class
)
public abstract class UpdateBase extends Extensible implements IUpdateBase {

  @JsonProperty("attribute")
  private List<@Valid Attribute> attributes;

  /**
   * The description for the artifact.
   */
  private @SafeText String description;

  /**
   * Possible values for the state of a managed artifact: 'incomplete', 'beta',
   * 'stable', 'deprecated'
   * <br/><p>Recommended values: incomplete, beta, stable, deprecated.
   *
   * @see org.opentmf.general.model.ManagedArtifactStateType
   */
  private @SafeText String state;

  /**
   * The artifact version description.
   */
  private @SafeText String versionDescription;
}