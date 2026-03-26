package org.opentmf.tmf730.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Quantity;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A SoftwareSpecification deployed using the SoftwareSupportPackage on platform
 * which meets the HostingPlatformRequirements.
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
    defaultImpl = InstalledSoftware.class
)
@Required(fields = {"href", "id"})
public class InstalledSoftware extends SoftwareResource implements IInstalledSoftware {

  /**
   * Indicates whether this software uses absolute (UTC) time.
   */
  private Boolean isUTCTime;

  /**
   * The time of the last start of this software.
   */
  private OffsetDateTime lastStartTime;

  /**
   * The current number of total processes that the Software can support at any
   * given time.
   */
  private Integer numProcessesActiveCurrent;

  /**
   * The ccurrent number of users of the Sofware.
   */
  private Integer numUsersCurrent;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity pagingFileSizeCurrent;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity processMemorySizeCurrent;

  /**
   * A set of identifying characters and/or numbers assigned to, and usually
   * marked on, each of a series of identical Software instances.
   */
  private @SafeText String serialNumber;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity swapSpaceUsedCurrent;
}