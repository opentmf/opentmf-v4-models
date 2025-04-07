package org.opentmf.v4.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * Keeps track of other names, for example the old name of an organization.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = OtherNameOrganization.class
)
public class OtherNameOrganization extends Extensible {

  /**
   * Organization name (department name for example).
   */
  private @SafeText String name;

  /**
   * Co. , Inc. , Ltd. , Pty Ltd. , Plc; , Gmbh.
   */
  private @SafeText String nameType;

  /**
   * The name that the organization trades under.
   */
  private @SafeText String tradingName;

  private @Valid TimePeriod validFor;
}