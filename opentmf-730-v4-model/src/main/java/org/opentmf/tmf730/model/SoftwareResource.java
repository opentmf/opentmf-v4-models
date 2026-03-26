package org.opentmf.tmf730.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.resource.model.LogicalResource;

/**
 * Abstract class describing the common set of attributes shared by all concrete
 * software resources (e.g. API, InstalledSoftware).
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
    defaultImpl = SoftwareResource.class
)
@Required(fields = {"href", "id"})
public class SoftwareResource extends LogicalResource implements ISoftwareResource {

  /**
   * True defines this SoftwareResource as being currently distributed across
   * several Resource nodes.
   */
  private Boolean isDistributedCurrent;

  /**
   * The time of the last update of this resource.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Defines the target platform that the SoftwareResource will be deployed on.
   */
  private @SafeText String targetPlatform;
}