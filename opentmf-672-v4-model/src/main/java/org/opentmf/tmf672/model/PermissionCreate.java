package org.opentmf.tmf672.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The Permission resource represents the entitlement given by an individual
 * (granter) to another individual (user) to get access to a set of his owned
 * manageable assets. One single permission resource can hold information
 * referring to privileges granted for multiple manageable assets.
 * <br/>Skipped properties: id,href,creationDate.
 *
 * <p><br/>
 * <strong>Required:</strong> user, validFor<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-672: User Role Permission Management API</li>
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
    defaultImpl = PermissionCreate.class
)
@Required(fields = {"validFor", "user"})
public class PermissionCreate extends Extensible implements IPermissionCreate {

  /**
   * List of: The AssetUserRole is the detailed information concerning an
   * individual user role.
   */
  @JsonProperty("assetUserRole")
  private List<@Valid AssetUserRole> assetUserRoles;

  /**
   * Text describing the contents of the payment.
   */
  private @SafeText String description;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  private @Valid RelatedParty granter;

  /**
   * List of: A Privilege is a detailed information concerning an individual
   * access entitlement.
   */
  @JsonProperty("privilege")
  private List<@Valid Privilege> privileges;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  private @Valid RelatedParty user;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}