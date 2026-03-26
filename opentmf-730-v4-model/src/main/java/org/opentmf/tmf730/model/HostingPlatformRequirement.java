package org.opentmf.tmf730.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Resource;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A HostingPlatformRequirement implements a
 * HostingPlatformRequirementSpecification for a specific InstalledSoftware.
 *
 * <p><br/>
 * <strong>Required:</strong> href, id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-730: Software And Compute Management API</li>
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
    defaultImpl = HostingPlatformRequirement.class
)
@Required(fields = {"href", "id"})
public class HostingPlatformRequirement extends Resource implements IHostingPlatformRequirement {

  /**
   * the value of the logical resource. E.g '0746712345' for MSISDN's.
   */
  private @SafeText String value;
}