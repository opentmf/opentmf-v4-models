package org.opentmf.tmf730.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Resource;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A SofwareSupportPackage represents the package acquired by a consumer from a
 * software vendor. It can be materialized as one or several files (data)
 * downloaded online or copied on a physical support. It contains all files
 * required for deployment and installation such as installation manager and at
 * minimum, one of the files constitutes the set of machine readable
 * instructions that will be executed automatically after it is installed.
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
    defaultImpl = SoftwareSupportPackage.class
)
@Required(fields = {"href", "id"})
public class SoftwareSupportPackage extends Resource implements ISoftwareSupportPackage {

  /**
   * This is a string attribute that defines the date of manufacture of this item
   * in the fixed format "dd/mm/yyyy". This is an optional attribute.
   */
  private OffsetDateTime manufactureDate;

  /**
   * This defines the current power status of the hardware item. Values include:
   * <br/>
   * <br/> 0: Unknown
   * <br/> 1: Not Applicable
   * <br/> 2: No Power Applied
   * <br/> 3: Full Power Applied
   * <br/> 4: Power Save - Normal
   * <br/> 5: Power Save - Degraded
   * <br/> 6: Power Save - Standby
   * <br/> 7: Power Save - Critical
   * <br/> 8: Power Save - Low Power Mode
   * <br/> 9: Power Save - Unknown
   * <br/> 10: Power Cycle
   * <br/> 11: Power Warning
   * <br/> 12: Power Off.
   */
  private @SafeText String powerState;

  /**
   * This is a string that represents a manufacturer-allocated number used to
   * identify different instances of the same hardware item. The ModelNumber and
   * PartNumber attributes are used to identify different types of hardware items.
   * This is a REQUIRED attribute.
   */
  private @SafeText String serialNumber;

  /**
   * This is a string that identifies the version of this physical resource. This
   * is an optional attribute.
   */
  private @SafeText String versionNumber;
}