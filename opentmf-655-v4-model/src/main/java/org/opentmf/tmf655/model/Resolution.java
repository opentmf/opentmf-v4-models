package org.opentmf.tmf655.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The way one or more change request has been implementation through a direct
 * remedy or task.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-655: Change Management API</li>
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
    defaultImpl = Resolution.class
)
public class Resolution extends NamedEntity implements IResolution {

  /**
   * The resolutions code, it can be configured as a multiple level hierarchy.
   */
  private @SafeText String code;

  /**
   * The description of the resolution.
   */
  private @SafeText String description;

  /**
   * List of: A step or task along in the process of implementation a Change
   * Request.
   */
  @JsonProperty("task")
  private List<@Valid Task> tasks;
}